package models

import interfaces.IEntity

import java.util.Date

/**
 * A class that stores the data for a post (Twit).
 */
class Twit : IEntity {

    override var id: Int = 0

    var content: String? = null

    var postedAt: Date? = null

    var user: User? = null
}
