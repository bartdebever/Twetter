package models

import interfaces.IEntity
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption
import javax.persistence.*

@Entity
@Table(name = "USERS")
class User : IEntity {
    @Id
    @GeneratedValue
    override var id: Int = 0
    var userName: String? = null
    var email: String? = null
    var password: String? = null
    var bio: String? = null
    var website: String? = null
    var imageUrl: String? = null

//    @OneToMany
//    var role: Role? = null

    @ManyToMany(fetch = FetchType.LAZY)
    private val following: MutableList<User>? = null

    fun getFollowing(): List<User>? {
        return following
    }

    fun addFollowing(user: User) {
        following!!.add(user)
    }
}
