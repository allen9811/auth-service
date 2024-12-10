package com.example.authservice.services;

import com.example.authservice.common.dto.TokenResponse;
import io.jsonwebtoken.Claims;

public interface JwtService {

    TokenResponse generateToken(Long userId);

    //Decodificar el JWT
    Claims getClaims(String token);

    boolean isExpired(String token);

    Integer extractUserId(String token);

}
