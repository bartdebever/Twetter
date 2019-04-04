package dtos

import java.io.Serializable

open class BasicUserDTO : Serializable {
    var userName: String? = null
    var id: Int = 0
    var bio: String? = null
    var email: String? = null
    var website: String? = null
}
