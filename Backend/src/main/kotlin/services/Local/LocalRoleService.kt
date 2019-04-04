package services.Local

import models.Role
import services.interfaces.IRoleService

class LocalRoleService : LocalCrudService<Role>(), IRoleService
