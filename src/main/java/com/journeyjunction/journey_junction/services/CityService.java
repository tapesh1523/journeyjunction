package com.journeyjunction.journey_junction.services;

import com.journeyjunction.journey_junction.dto.CityDto;

import java.util.List;

public interface CityService {
    CityDto getCity(Long cityId);
    CityDto getCityByName(String cityName);
    List<CityDto> getCityList();

    CityDto createCity(CityDto cityDto);
    CityDto updateCity(CityDto cityDto, Long cityId);
    void deleteCity(Long cityId);

}
