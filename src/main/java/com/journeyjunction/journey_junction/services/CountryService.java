package com.journeyjunction.journey_junction.services;

import com.journeyjunction.journey_junction.dto.CountryDto;
import com.journeyjunction.journey_junction.entities.Country;

import java.util.List;

public interface CountryService {
    CountryDto getCountry(Long countryId);

    CountryDto createCountry(CountryDto country);

    List<CountryDto> getAllCountries();

    CountryDto updateCountry(Long countryId, CountryDto country);

    void deleteCountry(Long countryId);


}
