package resources

import models.User
import services.interfaces.IUserService
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path

@Path("/test")
open class TestResource {
    @Inject
    open var userService: IUserService? = null

    @GET
    open fun getTest() : String {
        if (userService == null) {
            return "Not injected";
        }
        val user = User();
        user.userName = "Bort";

        userService!!.insert(user);
        return "Hello world!";
    }
}