package com.bartdebever.twetter.helpers.interfaces;

public interface IJwtTokenGenerator {
    /**
     * Generates a valid JWT token for the given parameters.
     * @param issuer the issuer of the token.
     * @param subject the subject of the token.
     * @param expireTime how long the token will last for.
     * @return the generated JWT token.
     */
    String generateToken(String issuer, String subject, long expireTime);

    /**
     * Verifies the token and gives back the subject.
     * @param jwtToken the JWT token wanting to be verified.
     * @return the subject from the JWT token.
     */
    String verifyToken(String jwtToken);
}
