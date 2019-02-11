package com.bartdebever.twetter.helpers.interfaces;

public interface IJwtTokenGenerator {
    String generateToken(String issuer, String subject, long expireTime);

    String verifyToken(String jwtToken);
}
