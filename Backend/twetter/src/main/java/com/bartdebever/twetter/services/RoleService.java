pacvoid addFollow(int followerId, int followingId)kage com.bartdebever.twetter.services;

import com.bartdebever.twetter.models.Role;
import com.bartdebever.twetter.services.interfaces.IRoleService;

/**
 * A service to perform CRUD actions for the Role class.
 */
public class RoleService extends CrudService<Role> implements IRoleService {
}
