package models

import interfaces.IEntity
import org.hibernate.annotations.LazyToOne

import java.util.Date
import javax.persistence.*

/**
 * A class that stores the data for a post (Twit).
 */
@Entity
@Table(name = "TWITS")
class Twit : IEntity {
    @Id
    @GeneratedValue
    override var id: Int = 0

    var content: String? = null

    var postedAt: Date? = null

    @ManyToOne
    var user: User? = null
}
