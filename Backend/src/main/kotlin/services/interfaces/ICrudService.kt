package services.interfaces

import interfaces.IEntity

interface ICrudService<T : IEntity> {

    /**
     * Gets all the entities in the application.
     * @return a list of all entities.
     */
    val all: List<T>?

    /**
     * Updates an entity in the underlying database.
     * @param entity the entity wanting to be updated.
     */
    fun update(entity: T)

    /**
     * Deletes an entity from the underlying database.
     * @param entity the entity wanting to be removed.
     */
    fun delete(entity: T)

    /**
     * Inserts an entity into the underlying database.
     * @param entity the entity wanting to be inserted.
     */
    fun insert(entity: T)

    /**
     * Gets a entity by it's id.
     * @param id the id of the entity.
     * @return the instance of the entity or null.
     */
    fun getById(id: Int): T?
}