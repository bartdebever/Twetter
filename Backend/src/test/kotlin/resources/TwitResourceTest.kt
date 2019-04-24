package resources

import dtos.TwitDTO
import models.Twit
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import services.local.LocalTwitService

class TwitResourceTest {
    private var twitResource: TwitResource? = null
    private val localTwitService: LocalTwitService = LocalTwitService()

    @BeforeEach
    fun initialize() {
        twitResource = TwitResource()
        twitResource!!.twitService = localTwitService
    }

    @Test
    fun getTwitsTest() {
        val twit = insertNewTwit()
        val response = twitResource!!.getTwits()
        val entity: Any? = response.entity
        // Assert that the response has a body and is of the correct type.
        assertNotNull(entity)
        assertEquals(ArrayList<TwitDTO>()::class.java, entity!!::class.java)
        // Assert that the list is the castable.
        val actualList = entity as ArrayList<TwitDTO>
        assertNotNull(actualList)

        val twitDTO = actualList[0]
        // Assert the data in the DTO is the same as the actual twit.
        assertEquals(twit.id, twitDTO.id)
        assertEquals(twit.content, twitDTO.content)
    }

    private fun insertNewTwit(): Twit {
        val twit = Twit()
        twit.content = "Test Twit"
        twit.id = 1

        localTwitService.insert(twit)

        return twit
    }

}