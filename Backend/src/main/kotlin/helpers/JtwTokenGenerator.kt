package helpers

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import java.util.*
import javax.crypto.spec.SecretKeySpec
import javax.sound.midi.SysexMessage
import javax.xml.bind.DatatypeConverter

object JtwTokenGenerator {

    val secret  = "REALLY REALLY REALLY REALLY REALLY REALLY REALLY REALLY REALLY FUCKING GOOD SECRET";

    fun generateToken(issuer: String, subject: String) : String {
        val algorithm = SignatureAlgorithm.HS256
        val currentMilis  = System.currentTimeMillis()
        val date = Date(currentMilis)
        val apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secret)

        val signingKey = SecretKeySpec(apiKeySecretBytes, algorithm.jcaName)
        val builder = Jwts.builder()
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(date)
                .setSubject(subject)
                .setIssuer(issuer)
                .signWith(signingKey, algorithm)

        val expireDate = currentMilis + 2400000
        builder.setExpiration(Date(expireDate))

        return builder.compact()
    }

    fun validateToken(jwtToken: String) : String {
        val claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(secret))
                .parseClaimsJws(jwtToken).body
        return claims.subject
    }
}