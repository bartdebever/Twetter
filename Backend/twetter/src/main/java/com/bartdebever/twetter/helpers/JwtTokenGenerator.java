package com.bartdebever.twetter.helpers;

import com.bartdebever.twetter.ApplicationConstants;
import com.bartdebever.twetter.helpers.interfaces.IJwtTokenGenerator;
import com.bartdebever.twetter.logging.interfaces.ILogger;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.logging.log4j.Logger;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

public class JwtTokenGenerator implements IJwtTokenGenerator {

    private static int idCounter;
    private final ILogger logger = Twetter.getLogger("JwtTokenGenerator");

    @Override
    public String generateToken(String issuer, String subject, long expireTime) {
        logger.info("Generating new token for subject: \"%s\"", subject);
        //The JWT signature algorithm we will be using to sign the token
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //We will sign our JWT with our ApiKey secret
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(ApplicationConstants.JWT_SECRET);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        //Let's set the JWT Claims
        JwtBuilder builder = Jwts.builder()
                .setId(String.valueOf(idCounter++))
                .setIssuedAt(now)
                .setSubject(subject)
                .setIssuer(issuer)
                .signWith(signingKey, signatureAlgorithm);

        //if it has been specified, let's add the expiration
        if (expireTime >= 0) {
            long expMillis = nowMillis + expireTime;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }

        //Builds the JWT and serializes it to a compact, URL-safe string
        return builder.compact();
    }

    @Override
    public String verifyToken(String jwtToken) {
        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(ApplicationConstants.JWT_SECRET))
                .parseClaimsJws(jwtToken).getBody();
        return claims.getSubject();
    }
}
