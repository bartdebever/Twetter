package services.local

import models.Role
import services.interfaces.IRoleService


class LocalRoleService : LocalCrudService<Role>(), IRoleService
