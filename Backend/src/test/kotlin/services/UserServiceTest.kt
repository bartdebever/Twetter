package services

import org.jboss.weld.junit5.WeldInitiator
import org.jboss.weld.junit5.WeldJunit5Extension
import org.jboss.weld.junit5.WeldSetup
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import services.interfaces.IUserService
import services.local.LocalUserService
import javax.enterprise.context.RequestScoped
import javax.inject.Inject


@ExtendWith(WeldJunit5Extension::class)
open class UserServiceTest {

    @WeldSetup
    var weld = WeldInitiator.from(LocalUserService::class.java).activate(RequestScoped::class.java).build()

    private var userService: IUserService? = null

    @Test
    open fun usernamePasswordLoginTest() {
        userService = weld.select(LocalUserService::class.java).get()
        assert(userService != null)
    }
}