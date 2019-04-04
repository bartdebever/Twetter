package dtos

import dtos.BasicUserDTO

class UserDTO : BasicUserDTO() {
    var twits: List<TwitDTO>? = null
    var following: List<BasicUserDTO>? = null
}
