package com.journeyjunction.journey_junction.services;

import com.journeyjunction.journey_junction.dto.CityDto;
import org.locationtech.jts.geom.Point;

import java.util.List;

public interface CityService {
    CityDto getCity(Long cityId);

    List<CityDto> getCityList();

    CityDto createCity(CityDto cityDto);
    CityDto updateCity(CityDto cityDto, Long cityId);
    void deleteCity(Long cityId);

    List<CityDto> findNearestCities(Point point, double distanceInKm);

    Point createPoint(double latitude, double longitude);
}
