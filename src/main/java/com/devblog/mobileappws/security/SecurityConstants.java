package com.devblog.mobileappws.security;

public class SecurityConstants {

    public static final long EXPIRATION_TIME = 1000 * 60 * 60 * 24;
    public static final String BEARER_PREFIX = "Bearer ";
    public static final String AUTH_HEADER = "Authorization";
    public static final String SIGN_UP_URL = "/users";
    public static final String TOKEN_SECURITY = "secret";
}
