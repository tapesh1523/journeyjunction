package com.journeyjunction.journey_junction.services.impl;

import com.journeyjunction.journey_junction.dto.CountryDto;
import com.journeyjunction.journey_junction.entities.Country;
import com.journeyjunction.journey_junction.exceptions.ResourceNotFoundException;
import com.journeyjunction.journey_junction.mapper.CountryMapper;
import com.journeyjunction.journey_junction.repositories.CountryRepository;
import com.journeyjunction.journey_junction.services.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    @Override
    public CountryDto getCountry(Long countryId) {
        Country country = countryRepository.findById(countryId).orElseThrow(()-> new ResourceNotFoundException("Country with Id "+ countryId + " not found"));
        return CountryMapper.toCountryDto(country);
    }

    @Override
    public CountryDto createCountry(CountryDto countryDto) {
        // Map DTO to Entity

        Country countryEntity = CountryMapper.toEntity(countryDto, new Country());

        // Save the entity to the database
        Country savedCountry = countryRepository.save(countryEntity);

        // Map the saved entity back to DTO
        return CountryMapper.toCountryDto(savedCountry);
    }

    @Override
    public List<CountryDto> getAllCountries() {
        // Retrieve the list of Country entities from the repository
        List<Country> countries = countryRepository.findAll();

        // Map the list of Country entities to a list of CountryDto objects using ModelMapper
        return countries.stream()
                .map(CountryMapper::toCountryDto) // Map each Country to CountryDto
                .collect(Collectors.toList()); // Collect the mapped objects into a List
    }

    @Override
    public CountryDto updateCountry(Long countryId, CountryDto country) {

        Country countryEntity = countryRepository.findById(countryId).orElseThrow(()-> new ResourceNotFoundException("Country with Id "+ countryId + " not found"));
        Country updatedCountry = CountryMapper.toEntity(country, countryEntity);

        return CountryMapper.toCountryDto(countryRepository.save(updatedCountry));

    }

    @Override
    public void deleteCountry(Long countryId) {
        if(!countryRepository.existsById(countryId)) {
            throw new ResourceNotFoundException("Country with Id "+ countryId + " not found");
        }
        else{
            countryRepository.deleteById(countryId);
        }
        return ;
    }
}
