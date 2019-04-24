package services

import models.User
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import services.interfaces.IUserService
import services.local.LocalUserService


open class UserServiceTest {

    private var userService: IUserService? = null
    private val userName = "TestUser"
    private val password = "Welcome1!"
    private val invalidId = -100
    private val notFoundId = 200

    @BeforeEach
    open fun initialize() {
        userService = LocalUserService()
    }
    //region getUserTest
    @Test
    fun getUserTest() {
        val user = insertNewUser()
        val receivedUser = userService!!.getById(user.id)

        assertSame(user, receivedUser)
    }

    @Test
    fun getUserBadFlowNotFoundTest() {
        val receivedUser = userService!!.getById(notFoundId)

        assertNull(receivedUser)
    }

    @Test
    fun getUserBadFlowInvalidIdTest() {
        assertThrows(IllegalArgumentException::class.java) { userService!!.getById(invalidId) }
    }
    //endregion
    //region insertUserTest
    @Test
    fun insertUserTest() {
        val user = insertNewUser()
        val receivedUser = userService!!.getById(user.id)!!

        assertSame(user, receivedUser)
    }
    //endregion

    //region removeUserTest
    @Test
    fun removeUserTest() {
        val user = insertNewUser()
        userService!!.delete(user)

        val receivedUser : User? = userService!!.getById(user.id)

        assertNull(receivedUser)
    }
    //endregion
    //region userLoginTest
    @Test
    open fun userLoginTest() {
        val user = insertNewUser()
        val loggedInUser: User? = userService!!.validateUser(userName, password)

        assertNotNull(loggedInUser)
        assertEquals(user.id, loggedInUser!!.id)
        assertSame(user, loggedInUser)
    }

    @Test
    fun userLoginBothBadFlowTest() {
        val receivedUser = userService!!.validateUser("Does not", "Exist")

        assertNull(receivedUser)
    }

    @Test
    fun userLoginUsernameBadFlowTest() {
        insertNewUser()
        val receivedUser = userService!!.validateUser("Is not correct", password)

        assertNull(receivedUser)
    }

    @Test
    fun userLoginPasswordBadFlow() {
        insertNewUser()
        val receivedUser = userService!!.validateUser(userName, "Is not correct")

        assertNull(receivedUser)
    }

    //endregion


    private fun createUser(): User {
        val user = User()
        user.id = 1
        user.userName = userName
        user.password = password

        return user;
    }

    private fun insertNewUser(): User {
        val user = createUser()
        userService!!.insert(user)

        return user;
    }
}