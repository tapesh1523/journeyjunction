package com.journeyjunction.journey_junction.services;

import com.journeyjunction.journey_junction.entities.User;

public interface SessionService {
    void generateSessions(User user, String refreshToken);
    void validateSession(String refreshToken);
}
