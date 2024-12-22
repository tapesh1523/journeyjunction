package com.journeyjunction.journey_junction.repositories;

import com.journeyjunction.journey_junction.dto.CityDto;
import com.journeyjunction.journey_junction.entities.City;
import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    Optional<City> findByName(String name);

    @Query("SELECT c FROM City c WHERE ST_DistanceSphere(c.location, :point) <= :distance")
    List<City> findCitiesWithinDistance(@Param("point") Point point, @Param("distance") double distance);
}
