package services.Local

import models.User
import services.interfaces.IUserService
import javax.enterprise.context.RequestScoped


class LocalUserService : LocalCrudService<User>(), IUserService {
    override fun validateUser(username: String, password: String): User? {
        for (user in entityList) {
            if (user.userName == username && user.password == password) {
                return user
            }
        }

        return null
    }

    override fun addFollow(followerId: Int, followingId: Int) {

    }

    override fun searchByName(username: String): User? {
        for (user in entityList) {
            if (user.userName == username) {
                return user
            }
        }

        return null
    }
}
