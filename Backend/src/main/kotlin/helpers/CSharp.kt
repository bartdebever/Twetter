package helpers

import interfaces.IEntity

/**
 * Helper methods that will be used to basically get the C# features in java.
 */
object CSharp {
    /**
     * Grabs the first entity that has an Id equal to the given id.
     * @param entityList the list of entities wanting to be searched.
     * @param id the id wanting to be searched for.
     * @return the entity or null.
     */
    fun <T : IEntity> firstOrDefault(entityList: List<T>, id: Int): T? {
        for (entity in entityList) {
            if (entity.id == id) {
                return entity
            }
        }

        return null
    }

    /**
     * Checks if the given String is null or whitespace.
     * @param string the string wanting to be checked.
     * @return a value to indicate if the string is null or whitespace.
     */
    fun isNullOrWhitespace(string: String?): Boolean {
        return string == null || string.trim { it <= ' ' } == ""
    }
}
