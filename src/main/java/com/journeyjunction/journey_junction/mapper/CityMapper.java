package com.journeyjunction.journey_junction.mapper;

import com.journeyjunction.journey_junction.dto.CityDto;
import com.journeyjunction.journey_junction.dto.PointDto;
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
                .location(toPointDto(city.getLocation()))  // Convert Point to PointDto
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
            city.setLocation(toPoint(cityDto.getLocation()));  // Convert PointDto to Point
        }

        // Set the State (if provided in DTO)
        if (state != null) {
            // You can fetch the actual State entity based on the ID if needed
            city.setState(state);  // Set the state reference in the City entity
        }

        return city;
    }

    // Convert Point to PointDto
    public static PointDto toPointDto(Point point) {
        if (point != null) {
            return new PointDto(new double[]{point.getX(), point.getY()});
        }
        return null;  // Return null if the Point is null
    }

    // Convert PointDto to Point
    public static Point toPoint(PointDto pointDto) {
        if (pointDto != null && pointDto.getCoordinates() != null && pointDto.getCoordinates().length == 2) {
            // Create a new Point from the coordinates (longitude, latitude)
            return new org.locationtech.jts.geom.GeometryFactory().createPoint(
                    new org.locationtech.jts.geom.Coordinate(pointDto.getCoordinates()[0], pointDto.getCoordinates()[1])
            );
        }
        return null;  // Return null if the PointDto is invalid
    }
}
