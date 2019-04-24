package dtos

import java.io.Serializable

class TwitDTO : Serializable {
    var user: BasicUserDTO? = null
    var content: String? = null
    var id: Int = 0
}
