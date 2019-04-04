package services

import models.Role
import services.interfaces.IRoleService
import javax.enterprise.context.RequestScoped
import javax.enterprise.inject.Default

/**
 * A service to perform CRUD actions for the Role class.
 */
@RequestScoped
@Default
open class RoleService : CrudService<Role>(), IRoleService {

    override val all: List<Role>?
        get() = null

    override fun getById(id: Int): Role {
        return session.get<Role>(Role::class.java, id)
    }
}
