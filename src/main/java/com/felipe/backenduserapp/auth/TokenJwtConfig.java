package com.felipe.backenduserapp.auth;

import java.security.Key;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class TokenJwtConfig {
    // public final static String SECRET_KEY = "algun_token_con_frase.";
    public final static Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS512); 

    public final static String PREFIX_TOKEN= "Bearer ";
    public final static String HEADER_AUTHORIZATION ="Authorization";
   



}
