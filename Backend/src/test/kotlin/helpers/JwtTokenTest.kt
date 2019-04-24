package helpers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class JwtTokenTest {

    @Test
    fun jtwTokenGoodFlow() {
        val token = JtwTokenGenerator.generateToken("Issuer", "Subject")

        assertNotNull(token)
        assert(token.isNotEmpty())
    }

    @Test
    fun jtwTokenValidateGoodFlow() {
        val issuer = "Test Issuer"
        val subject = "Test Subject"
        val token = JtwTokenGenerator.generateToken(issuer, subject)

        val receivedSubject = JtwTokenGenerator.validateToken(token)

        assertNotNull(receivedSubject)
        assert(receivedSubject.isNotEmpty())
        assertEquals(subject, receivedSubject)
    }
}