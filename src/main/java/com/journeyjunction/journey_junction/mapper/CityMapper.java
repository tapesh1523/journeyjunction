package com.journeyjunction.journey_junction.mapper;

import com.journeyjunction.journey_junction.dto.CityDto;
import com.journeyjunction.journey_junction.entities.City;
import com.journeyjunction.journey_junction.entities.State;
import org.locationtech.jts.geom.Point;

public class CityMapper {

    // Convert City entity to CityDto
    public static CityDto toCityDto(City city) {
        return CityDto.builder()
                .id(city.getId())
                .name(city.getName())
                .description(city.getDescription())
                .stateId(city.getState() != null ? city.getState().getId() : null)  // Map state_id from State entity
                .crowdedMonth(city.getCrowdedMonth())
                .timeToVisit(city.getTimeToVisit())
                .airport(city.getAirport())
                .railwayStation(city.getRailwayStation())
                .busStation(city.getBusStation())
                .duration(city.getDuration())
                .location(city.getLocation())  // Assuming `Point` is used for the location
                .build();
    }

    // Convert CityDto to City entity
    public static City toEntity(CityDto cityDto, City city, State state) {
        // Set the ID if not null (for update scenario)
        if(cityDto.getId() != null) {
            city.setId(cityDto.getId());
        }
        if(cityDto.getName() != null) {
            city.setName(cityDto.getName());
        }
        if(cityDto.getDescription() != null) {
            city.setDescription(cityDto.getDescription());
        }
        if(cityDto.getCrowdedMonth() != null) {
            city.setCrowdedMonth(cityDto.getCrowdedMonth());
        }
        if(cityDto.getTimeToVisit() != null) {
            city.setTimeToVisit(cityDto.getTimeToVisit());
        }
        if(cityDto.getAirport() != null) {
            city.setAirport(cityDto.getAirport());
        }
        if(cityDto.getRailwayStation() != null) {
            city.setRailwayStation(cityDto.getRailwayStation());
        }
        if(cityDto.getBusStation() != null) {
            city.setBusStation(cityDto.getBusStation());
        }
        if(cityDto.getDuration() != null) {
            city.setDuration(cityDto.getDuration());
        }
        if(cityDto.getLocation() != null) {
            city.setLocation(cityDto.getLocation());
        }

        // Set the State (if provided in DTO)
        if (state != null) {
              // You can fetch the actual State entity based on the ID if needed
            city.setState(state);  // Set the state reference in the City entity
        }

        return city;
    }
}
