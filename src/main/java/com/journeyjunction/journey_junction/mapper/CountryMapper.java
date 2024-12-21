package com.journeyjunction.journey_junction.mapper;

import com.journeyjunction.journey_junction.dto.CountryDto;
import com.journeyjunction.journey_junction.entities.Country;

public class CountryMapper {
    public static CountryDto toCountryDto(Country country) {
        return CountryDto.builder()
                .id(country.getId())
                .name(country.getName())
                .description(country.getDescription())
                .build();
    }

    public static Country toCountry(CountryDto countryDto) {
        Country country = new Country();
        country.setId(countryDto.getId());
        country.setName(countryDto.getName());
        country.setDescription(countryDto.getDescription());
        return country;
    }
}
