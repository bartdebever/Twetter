package services.Local

import models.User
import services.interfaces.IUserService

class LocalUserService : LocalCrudService<User>(), IUserService {
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