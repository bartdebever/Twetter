package dtos

class UserDTO : BasicUserDTO() {
    var twits: List<TwitDTO>? = null
    var following: List<BasicUserDTO>? = null
}
