package com.bartdebever.twetter.services;

import com.bartdebever.twetter.models.interfaces.IEntity;
import com.bartdebever.twetter.services.interfaces.ICrudService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * An abstract class used to perform some CRUD actions (Create, Read, Update, Delete)
 * @param <T> the type that the entity is wanting to perform these actions on.
 */
public abstract class CrudService<T extends IEntity> implements ICrudService<T> {
    private static SessionFactory sessionFactory;
    private EntityManagerFactory entityManagerFactory;

    /**
     * Updates an entity in the underlying database.
     * @param entity the entity wanting to be updated.
     */
    public void update(T entity) {
        Session session = getSession();
        session.beginTransaction();
        session.update(entity);

        commitSessions(session);
    }

    /**
     * Deletes an entity from the underlying database.
     * @param entity the entity wanting to be removed.
     */
    public void delete(T entity) {
        Session session = getSession();
        session.beginTransaction();
        session.delete(entity);

        commitSessions(session);
    }

    /**
     * Inserts an entity into the underlying database.
     * @param entity the entity wanting to be inserted.
     */
    public void insert(T entity) {
        Session session = getSession();
        session.beginTransaction();
        session.save(entity);

        commitSessions(session);
    }

    /**
     * Gets the entity manager which is used by the Crud services.
     * @return the entity manager.
     */
    EntityManager getEntityManager() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.twetter.jpa");
        }

        return entityManagerFactory.createEntityManager();
    }

    Session getSession() {
        if (sessionFactory == null) {
            try {
                setUp();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory.openSession();
    }

    void commitSessions(Session session) {
        session.getTransaction().commit();
        session.close();
    }

    protected void setUp() throws Exception {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy( registry );
            e.printStackTrace();
        }
    }
}
