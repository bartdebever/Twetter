package services.Local

import helpers.CSharp
import interfaces.IEntity
import services.interfaces.ICrudService

import java.util.ArrayList

abstract class LocalCrudService<T : IEntity> internal constructor() : ICrudService<T> {
    val entityList: MutableList<T>

    override val all: List<T>
        get() = entityList

    init {
        entityList = ArrayList()
    }

    override fun update(entity: T) {
        checkForNull(entity)
        val existingEntity = entityList.firstOrNull { x -> x.id == entity.id }
        entityList[entityList.indexOf(existingEntity)] = entity
    }

    override fun delete(entity: T) {
        checkForNull(entity)
        val existingEntity = entityList.firstOrNull { x -> x.id == entity.id }
        entityList.remove(existingEntity)
    }

    override fun insert(entity: T) {
        checkForNull(entity)
        entityList.add(entity)
    }

    override fun getById(id: Int): T? {
        if (id <= 0) {
            throw IllegalArgumentException("Id must be greater than 0")
        }

        return entityList.firstOrNull { x -> x.id == id }
    }

    @Throws(IllegalArgumentException::class)
    private fun checkForNull(entity: T?) {
        if (entity == null) {
            throw IllegalArgumentException("entity can not be null")
        }
    }

    internal fun getEntityList(): List<T> {
        return entityList
    }
}
