package com.journeyjunction.journey_junction.repositories;

import com.journeyjunction.journey_junction.entities.Session;
import com.journeyjunction.journey_junction.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {

    List<Session> findByUser(User userId);

    Optional<Session> findByRefreshToken(String refreshToken);

}
