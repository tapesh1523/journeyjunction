package com.journeyjunction.journey_junction.services.impl;

import com.journeyjunction.journey_junction.dto.CityDto;
import com.journeyjunction.journey_junction.entities.City;
import com.journeyjunction.journey_junction.exceptions.ResourceNotFoundException;
import com.journeyjunction.journey_junction.repositories.CityRepository;
import com.journeyjunction.journey_junction.services.CityService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final ModelMapper modelMapper;

    @Override
    public CityDto getCity(Long cityId) {
        return modelMapper.map(cityRepository.findById(cityId), CityDto.class);
    }

    @Override
    public CityDto getCityByName(String cityName) {
        return modelMapper.map(cityRepository.findByName(cityName), CityDto.class);
    }

    @Override
    public List<CityDto> getCityList() {
        List<City> cities = cityRepository.findAll();
        return cities.stream()
                .map(city -> modelMapper.map(city, CityDto.class))
                .collect(Collectors.toList());
    }



    @Override
    public CityDto createCity(CityDto cityDto) {
        City city = modelMapper.map(cityDto, City.class);
        return modelMapper.map(cityRepository.save(city), CityDto.class);
    }

    @Override
    public CityDto updateCity(CityDto cityDto, Long cityId) {
        City city = cityRepository.findById(cityId).orElseThrow(()->new ResourceNotFoundException("City not found with Id"+cityId));
        cityDto.setId(city.getId());
        modelMapper.map(cityDto, city);
        City updatedCity = cityRepository.save(city);
        return modelMapper.map(updatedCity, CityDto.class);
    }

    @Override
    public void deleteCity(Long cityId) {
        cityRepository.deleteById(cityId);
        return ;
    }
}
