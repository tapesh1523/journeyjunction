package com.journeyjunction.journey_junction.repositories;

import com.journeyjunction.journey_junction.entities.SuitableFor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuitableForRepository extends JpaRepository<SuitableFor, Long> {
    SuitableFor findByName(String name);
}
