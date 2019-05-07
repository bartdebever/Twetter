package models

import interfaces.IEntity
import java.util.*
import javax.persistence.*

/**
 * A class that stores the data for a post (Twit).
 */
@Entity
@Table(name = "TWITS")
open class Twit : IEntity {
    @Id
    @GeneratedValue
    override var id: Int = 0

    var content: String? = null

    var postedAt: Date? = null

    @ManyToOne
    @JoinColumn(name = "authorId")
    var user: User? = null

    var authorId: Int? = null
}
