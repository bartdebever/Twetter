package services.Local

import models.Role
import services.interfaces.IRoleService
import javax.enterprise.context.RequestScoped

@RequestScoped
class LocalRoleService : LocalCrudService<Role>(), IRoleService
