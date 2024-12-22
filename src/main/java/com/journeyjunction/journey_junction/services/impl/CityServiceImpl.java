package com.journeyjunction.journey_junction.services.impl;

import com.journeyjunction.journey_junction.dto.CityDto;
import com.journeyjunction.journey_junction.entities.City;
import com.journeyjunction.journey_junction.entities.State;
import com.journeyjunction.journey_junction.exceptions.ResourceNotFoundException;
import com.journeyjunction.journey_junction.mapper.CityMapper;
import com.journeyjunction.journey_junction.repositories.CityRepository;
import com.journeyjunction.journey_junction.repositories.StateRepository;
import com.journeyjunction.journey_junction.services.CityService;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Point;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final StateRepository stateRepository;
    @Override
    public CityDto getCity(Long cityId) {
        return CityMapper.toCityDto(cityRepository.findById(cityId).orElseThrow(ResourceNotFoundException::new));
    }


    @Override
    public List<CityDto> getCityList() {
        List<City> cities = cityRepository.findAll();
        return cities.stream()
                .map(CityMapper::toCityDto)
                .collect(Collectors.toList());
    }



    @Override
    public CityDto createCity(CityDto cityDto) {
        State state = stateRepository.findById(cityDto.getStateId()).orElseThrow(ResourceNotFoundException::new);
        City city = CityMapper.toEntity(cityDto, new City(), state);
        City savedCity = cityRepository.save(city);
        return CityMapper.toCityDto(savedCity);
    }

    @Override
    public CityDto updateCity(CityDto cityDto, Long cityId) {
        City city = cityRepository.findById(cityId).orElseThrow(()->new ResourceNotFoundException("City not found with Id"+cityId));
        State state = stateRepository.findById(cityDto.getStateId()).orElseThrow(ResourceNotFoundException::new);
        City updatedCity = CityMapper.toEntity(cityDto, city, state);

        City savedCity = cityRepository.save(city);

        return CityMapper.toCityDto(savedCity);
    }

    @Override
    public void deleteCity(Long cityId) {
        if (cityRepository.findById(cityId).isPresent()) {
            cityRepository.deleteById(cityId);
        }
        else{
            throw new ResourceNotFoundException("City not found with Id"+cityId);
        }
        return ;
    }

    @Override
    public List<CityDto> getCitiesNearby(Long cityId, double radius) {
        City city = cityRepository.findById(cityId).orElseThrow(() -> new ResourceNotFoundException("City not found with Id" + cityId));


        Point cityLocation = city.getLocation();


        List<City> nearbyCities = cityRepository.findCitiesWithinDistance(cityLocation, radius * 1000);

        return nearbyCities.stream()
                .map(CityMapper::toCityDto)
                .collect(Collectors.toList());
    }


    @Override
    public Point createPoint(double latitude, double longitude) {

        Point point = new org.locationtech.jts.geom.GeometryFactory().createPoint(new org.locationtech.jts.geom.Coordinate(longitude, latitude));
        point.setSRID(4326);

        return point;
    }
}
