package resources

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

        return "Hello world!";
    }
}