package com.journeyjunction.journey_junction.repositories;

import com.journeyjunction.journey_junction.entities.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {
}
