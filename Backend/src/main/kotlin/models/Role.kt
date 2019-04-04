package models

import interfaces.IEntity
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

/**
 * Class intended to be used to manage permissions.
 */
@Entity
@Table(name = "ROLES")
class Role : IEntity {
    @Id
    @GeneratedValue
    override var id: Int = 0

    var name: String? = null
}
