package models

import javax.persistence.Entity
import javax.persistence.Table

/**
 * A Twit that is a reply to another Twit.
 * This effect can stack multiple times.
 */
@Entity
@Table(name = "REPLIES")
class Reply : Twit() {
    private var parentId: Int? = null

    /**
     * Gets the parent Twit's Id.
     * @return the parent's id.
     */
    fun getParentId(): Int {
        return parentId!!
    }

    /**
     * Sets the parent Twit's id.
     * @param parentId the id of the parent's Twit.
     */
    fun setParentId(parentId: Int) {
        this.parentId = parentId
    }
}
