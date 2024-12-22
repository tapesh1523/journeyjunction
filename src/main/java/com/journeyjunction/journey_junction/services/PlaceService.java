package com.journeyjunction.journey_junction.services;

import com.journeyjunction.journey_junction.dto.PlaceDto;

import java.util.List;

public interface PlaceService {
    PlaceDto create(PlaceDto placeDto);
    PlaceDto update(PlaceDto placeDto, Long placeId);
    void delete(Long id);
    PlaceDto getPlace(Long id);
    List<PlaceDto> getPlaces();

}
