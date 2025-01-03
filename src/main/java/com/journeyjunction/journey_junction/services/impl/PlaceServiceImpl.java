package com.journeyjunction.journey_junction.services.impl;

import com.journeyjunction.journey_junction.dto.PlaceDto;
import com.journeyjunction.journey_junction.entities.City;
import com.journeyjunction.journey_junction.entities.Place;
import com.journeyjunction.journey_junction.exceptions.ResourceNotFoundException;
import com.journeyjunction.journey_junction.mapper.PlaceMapper;
import com.journeyjunction.journey_junction.repositories.CityRepository;
import com.journeyjunction.journey_junction.repositories.PlaceRepository;
import com.journeyjunction.journey_junction.services.PlaceService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlaceServiceImpl implements PlaceService {
    private final PlaceRepository placeRepository;
    private final CityRepository cityRepository;


    @Override
    public PlaceDto create(PlaceDto placeDto) {
        City city = cityRepository.findById(placeDto.getCityId()).orElseThrow(ResourceNotFoundException::new);
        Place place = PlaceMapper.toEntity(placeDto, new Place(), city);
        Place savedPlace = placeRepository.save(place);
        return PlaceMapper.toPlaceDto(savedPlace);
    }

    @Override
    public PlaceDto update(PlaceDto placeDto, Long placeId) {
        Place place = placeRepository.findById(placeId).orElseThrow(ResourceNotFoundException::new);
        City city = cityRepository.findById(placeDto.getCityId()).orElseThrow(ResourceNotFoundException::new);
        Place updatedPlace = PlaceMapper.toEntity(placeDto, place, city);
        Place savedPlace = placeRepository.save(updatedPlace);
        return PlaceMapper.toPlaceDto(savedPlace);
    }

    @Override
    public void delete(Long id) {
        if (placeRepository.existsById(id)) {
            placeRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException();
        }
        return;

    }

    @Override
    public PlaceDto getPlace(Long id) {
        return PlaceMapper.toPlaceDto(placeRepository.findById(id).orElseThrow(ResourceNotFoundException::new));
    }

    @Override
    public List<PlaceDto> getPlaces() {
        List<Place> places = placeRepository.findAll();
        return places.stream().map(PlaceMapper::toPlaceDto).collect(Collectors.toList());
    }
}
