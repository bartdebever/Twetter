package resources

import com.google.gson.reflect.TypeToken
import dtos.BasicUserDTO
import dtos.NewUserDTO
import dtos.UserDTO
import helpers.Twetter
import models.User
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/users")
open class UserResource : BaseResource() {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    open fun getUsers() : Response {
        val mapper = Twetter.getModelMapper()
        val type = object: TypeToken<List<BasicUserDTO>>() {}.type

        return Response.ok(mapper.map(userService!!.all, type)).build()
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    open fun getUser(@PathParam("id") id: Int?) : Response {

        val mapper = Twetter.getModelMapper()
        if (id == null) {
            return Response.status(400).build()
        }

        val user  = userService!!.getById(id)
        if (user == null) {
            return Response.status(404).entity("No user found with id \"$id\"").build()
        }

        return Response.ok(mapper.map(user, UserDTO::class.java)).build()
    }

    @POST
    open fun createUser(newUser : NewUserDTO) : Response {
        val mapper = Twetter.getModelMapper()
        val mappedUser = mapper.map(newUser, User::class.java)
        userService!!.insert(mappedUser)

        return Response.ok().build()
    }
}