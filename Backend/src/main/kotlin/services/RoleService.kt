package services

import models.Role
import services.interfaces.IRoleService
import javax.enterprise.context.RequestScoped
import javax.enterprise.inject.Default
import javax.inject.Named

/**
 * A service to perform CRUD actions for the Role class.
 */
@Default
@RequestScoped
@Named("Role")
open class RoleService : CrudService<Role>(), IRoleService {

    override val all: List<Role>?
        get() = null

    override fun getById(id: Int): Role {
        return entityManager!!.find(Role::class.java, id)
    }
}
