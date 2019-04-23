package resources

import dtos.UserDTO
import helpers.JtwTokenGenerator
import helpers.Twetter
import javax.ws.rs.*
import javax.ws.rs.core.Context
import javax.ws.rs.core.HttpHeaders
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("authorization")
open class AuthorizationResource : BaseResource() {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    open fun getCurrentUser(@Context httpHeaders: HttpHeaders): Response {
        val user = validateJwtToken(httpHeaders)

        val userDto = Twetter.getModelMapper().map(user, UserDTO::class.java)

        return Response.ok(userDto).build()
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    open fun login(@FormParam("username") username: String,@FormParam("password") password: String): Response {
        System.out.println(username)
        val user = userService!!.validateUser(username, password)

        if (user == null) {
            return Response.status(Response.Status.BAD_REQUEST).build()
        }

        val token = JtwTokenGenerator.generateToken("Twetter.com", user!!.id.toString())

        return Response.ok(token).build()
    }
}
