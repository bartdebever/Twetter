package resources

import helpers.JtwTokenGenerator
import models.User
import services.interfaces.IUserService
import javax.inject.Inject
import javax.ws.rs.core.HttpHeaders
import javax.ws.rs.core.Response

open class BaseResource {
    @Inject
    open var userService: IUserService? = null;

    open fun validateJwtToken(httpHeaders: HttpHeaders) : User? {
        val token = httpHeaders.getHeaderString("Authorization")
        if (token == null || token == "") {
            return null;
        }

        val subject = JtwTokenGenerator.validateToken(token)
        return userService!!.getById(subject.toInt())
    }
}
