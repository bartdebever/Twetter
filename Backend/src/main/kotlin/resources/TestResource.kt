package resources

import javax.ws.rs.GET
import javax.ws.rs.Path

@Path("/test")
class TestResource {
    @GET
    fun getTest() : String {
        return "Hello world!";
    }
}