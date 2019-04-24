package resources

import com.google.gson.reflect.TypeToken
import dtos.TwitDTO
import helpers.Twetter
import models.Twit
import services.interfaces.ITwitService
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.Context
import javax.ws.rs.core.HttpHeaders
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/twits")
open class TwitResource : BaseResource() {
    @Inject
    open var twitService : ITwitService? = null

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    open fun getTwits() : Response {
        val twitList = twitService!!.all
        val mapper = Twetter.getModelMapper()
        val type = object: TypeToken<List<TwitDTO>>() {}.type;

        return Response.ok(mapper.map(twitList, type)).build()
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    open fun createTwit(twitDTO: TwitDTO, @Context httpHeaders: HttpHeaders) : Response {
        val user = validateJwtToken(httpHeaders)
        if (user == null) {
            return Response.status(Response.Status.UNAUTHORIZED).build()
        }
        val mapper = Twetter.getModelMapper()
        val newTwit =  mapper.map(twitDTO, Twit::class.java)
        newTwit.user = user
        twitService!!.insert(newTwit)

        return Response.ok().build()
    }
}