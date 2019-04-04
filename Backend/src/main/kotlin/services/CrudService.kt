package services

import interfaces.IEntity
import org.hibernate.Session
import org.hibernate.SessionFactory
import org.hibernate.boot.MetadataSources
import org.hibernate.boot.registry.StandardServiceRegistryBuilder
import services.interfaces.ICrudService
import javax.annotation.Resource

import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence
import javax.persistence.PersistenceContext
import javax.transaction.UserTransaction

/**
 * An abstract class used to perform some CRUD actions (Create, Read, Update, Delete)
 * @param <T> the type that the entity is wanting to perform these actions on.
</T> */
abstract class CrudService<T : IEntity> : ICrudService<T> {
    private var entityManagerFactory: EntityManagerFactory? = null

    open var sessionFactory: SessionFactory? = null
    /**
     * Gets the entity manager which is used by the Crud services.
     * @return the entity manager.
     */
    @PersistenceContext(name = "Twetter")
    internal val entityManager: EntityManager? = null

    @Resource
    val transaction: UserTransaction? = null

    internal val session: Session
        get() {
            if (sessionFactory == null) {
                try {
                    //setUp()
                } catch (e: Exception) {
                    e.printStackTrace()
                }

            }
            return sessionFactory!!.openSession()
        }

    /**
     * Updates an entity in the underlying database.
     * @param entity the entity wanting to be updated.
     */
    override fun update(entity: T) {
        val session = session
        session.beginTransaction()
        session.update(entity)

        commitSessions(session)
    }

    /**
     * Deletes an entity from the underlying database.
     * @param entity the entity wanting to be removed.
     */
    override fun delete(entity: T) {
        val session = session
        session.beginTransaction()
        session.delete(entity)

        commitSessions(session)
    }

    /**
     * Inserts an entity into the underlying database.
     * @param entity the entity wanting to be inserted.
     */
    override fun insert(entity: T) {
        transaction!!.begin()
        entityManager!!.persist(entity)
        transaction.commit()
    }

    internal fun commitSessions(session: Session) {
        session.transaction.commit()
        session.close()
    }
//
//    @Throws(Exception::class)
//    protected fun setUp() {
//        // A SessionFactory is set up once for an application!
//        val registry = StandardServiceRegistryBuilder()
//                .configure() // configures settings from hibernate.cfg.xml
//                .build()
//        try {
//            sessionFactory = MetadataSources(registry).buildMetadata().buildSessionFactory()
//        } catch (e: Exception) {
//            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
//            // so destroy it manually.
//            StandardServiceRegistryBuilder.destroy(registry)
//            e.printStackTrace()
//        }
//
//    }
}
