package models

import interfaces.IEntity

class User : IEntity {
    override var id: Int = 0
    var userName: String? = null
    var email: String? = null
    var password: String? = null
    var bio: String? = null
    var website: String? = null
    var imageUrl: String? = null
    var role: Role? = null
    private val following: MutableList<User>? = null

    fun getFollowing(): List<User>? {
        return following
    }

    fun addFollowing(user: User) {
        following!!.add(user)
    }
}
