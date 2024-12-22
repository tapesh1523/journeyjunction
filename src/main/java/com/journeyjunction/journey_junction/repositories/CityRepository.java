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
//    hello

    @Query(value = "SELECT  c.* " +
                    "From city c " +
                    "WHERE ST_DWithin(c.location, :point, :distanceInMeters) = true " +
                    "Order BY c.name", nativeQuery = true)
    List<CityDto> findByPointAndDistanceInKm(@Param("point") Point point, @Param("distanceInMeters") double distanceInMeters);

}
