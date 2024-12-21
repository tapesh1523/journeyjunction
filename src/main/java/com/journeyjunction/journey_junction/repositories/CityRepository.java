package com.journeyjunction.journey_junction.repositories;

import com.journeyjunction.journey_junction.dto.CityDto;
import com.journeyjunction.journey_junction.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    Optional<City> findByName(String name);

}
