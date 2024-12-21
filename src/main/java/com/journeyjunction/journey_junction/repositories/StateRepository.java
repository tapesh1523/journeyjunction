package com.journeyjunction.journey_junction.repositories;

import com.journeyjunction.journey_junction.entities.State;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {

}
