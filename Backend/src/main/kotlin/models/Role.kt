package models

import interfaces.IEntity

/**
 * Class intended to be used to manage permissions.
 */
class Role : IEntity {

    override var id: Int = 0

    var name: String? = null
}
