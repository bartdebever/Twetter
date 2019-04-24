package services.local

import models.Role
import services.interfaces.IRoleService
import javax.enterprise.context.RequestScoped
import javax.enterprise.inject.Alternative
import javax.inject.Named

@RequestScoped
@Named("RoleTest")
@Alternative
class LocalRoleService : LocalCrudService<Role>(), IRoleService
