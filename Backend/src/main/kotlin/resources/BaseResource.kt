package resources

import helpers.JtwTokenGenerator
import models.User
import services.interfaces.IUserService
import javax.inject.Inject
import javax.ws.rs.core.HttpHeaders

open class BaseResource {
    @Inject
    open var userService: IUserService? = null;

    open fun validateJwtToken(httpHeaders: HttpHeaders) : User? {
        var token = httpHeaders.getHeaderString("authorization")
        if (token == null || token == "") {
            return null;
        }

        token = token.substring("Bearer ".length);
        System.out.println(token)
        val subject = JtwTokenGenerator.validateToken(token)
        return userService!!.getById(subject.toInt())
    }
}
