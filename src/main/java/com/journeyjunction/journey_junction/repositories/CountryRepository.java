package com.journeyjunction.journey_junction.repositories;

import com.journeyjunction.journey_junction.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    // You can add custom query methods here if needed
}
