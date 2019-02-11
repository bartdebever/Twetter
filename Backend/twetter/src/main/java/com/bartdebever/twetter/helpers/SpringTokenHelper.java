package com.bartdebever.twetter.helpers;

import org.springframework.http.HttpHeaders;

public class SpringTokenHelper {
    /**
     * Gets the JWT token from the HTTP Headers.
     * @param headers the provided headers.
     * @return the JWT token.
     */
    public static String getTokenFromHeader(HttpHeaders headers) {
        String token = headers.get("Authorization").toString();

        // Swagger UI puts brackets around the token, needs to be removed before parsing token.
        if (token.contains("[")) {
            token = token.substring(1, token.length() - 1);
        }

        return token;
    }
}
