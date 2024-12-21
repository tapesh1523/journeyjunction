package com.journeyjunction.journey_junction.services.impl;

import com.journeyjunction.journey_junction.dto.CountryDto;
import com.journeyjunction.journey_junction.entities.Country;
import com.journeyjunction.journey_junction.exceptions.ResourceNotFoundException;
import com.journeyjunction.journey_junction.mapper.CountryMapper;
import com.journeyjunction.journey_junction.repositories.CountryRepository;
import com.journeyjunction.journey_junction.services.CountryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;
    private final ModelMapper modelMapper;

    @Override
    public CountryDto getCountry(Long countryId) {
        Country country = countryRepository.findById(countryId).orElseThrow(()-> new RuntimeException("Country with Id "+ countryId + " not found"));
        return CountryMapper.toCountryDto(country);
    }

    @Override
    public CountryDto createCountry(CountryDto countryDto) {
        // Map DTO to Entity
        Country countryEntity = modelMapper.map(countryDto, Country.class);

        // Save the entity to the database
        Country savedCountry = countryRepository.save(countryEntity);

        // Map the saved entity back to DTO
        return modelMapper.map(savedCountry, CountryDto.class);
    }

    @Override
    public List<CountryDto> getAllCountries() {
        // Retrieve the list of Country entities from the repository
        List<Country> countries = countryRepository.findAll();

        // Map the list of Country entities to a list of CountryDto objects using ModelMapper
        return countries.stream()
                .map(country -> modelMapper.map(country, CountryDto.class)) // Map each Country to CountryDto
                .collect(Collectors.toList()); // Collect the mapped objects into a List
    }

    @Override
    public CountryDto updateCountry(Long countryId, CountryDto country) {
        Country countryEntity = countryRepository.findById(countryId).orElseThrow(()-> new ResourceNotFoundException("Country with Id "+ countryId + " not found"));
        country.setId(countryId);
        modelMapper.map(country, countryEntity);
        return modelMapper.map(countryRepository.save(countryEntity), CountryDto.class);

    }

    @Override
    public void deleteCountry(Long countryId) {
        countryRepository.deleteById(countryId);
        return ;
    }
}
