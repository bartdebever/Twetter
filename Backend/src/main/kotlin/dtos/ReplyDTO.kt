package dtos

import java.io.Serializable

class ReplyDTO : Serializable {
    /**
     * Gets the content of the reply.
     * @return
     */
    /**
     * Sets the content of the reply.
     * @param content the content wanting to be set.
     */
    var content: String? = null
    /**
     * Gets the parent Twit's id.
     * @return the parent Twit's id.
     */
    /**
     * Sets the parent Twit's id.
     * @param parentId the value intending to be set.
     */
    var parentId: Int = 0
}
