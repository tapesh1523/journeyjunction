package com.journeyjunction.journey_junction.services.impl;

import com.journeyjunction.journey_junction.entities.Session;
import com.journeyjunction.journey_junction.entities.User;
import com.journeyjunction.journey_junction.repositories.SessionRepository;
import com.journeyjunction.journey_junction.services.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SessionServiceImpl implements SessionService {

    private final SessionRepository sessionRepository;
    private final int SESSION_LIMIT = 2;


    @Override
    public void generateSessions(User user, String refreshToken) {
        List<Session> sessions = sessionRepository.findByUser(user);
        if (sessions.size() == SESSION_LIMIT) {
            sessions.sort(Comparator.comparing(Session::getLastUsedAt));
            Session firstSession = sessions.getFirst();
            sessionRepository.delete(firstSession);

        }
        Session newSession = Session.builder()
                .user(user)
                .refreshToken(refreshToken)
                .build();

        sessionRepository.save(newSession);

    }

    @Override
    public void validateSession(String refreshToken) {
        Session session = sessionRepository.findByRefreshToken(refreshToken).orElseThrow(()-> new SessionAuthenticationException("Invalid refresh token"));
        session.setLastUsedAt(LocalDateTime.now());
        sessionRepository.save(session);
    }
}
