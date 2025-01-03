package com.journeyjunction.journey_junction.services;

import com.journeyjunction.journey_junction.entities.User;

import javax.crypto.SecretKey;

public interface JwtService {
    SecretKey getSecretKey();
    String generateAccessToken(User user);
    String generateRefreshToken(User user);
    Long getUserId(String token);
}
