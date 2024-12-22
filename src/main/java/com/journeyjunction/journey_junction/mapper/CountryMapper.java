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

    public static Country toEntity(CountryDto countryDto, Country country) {
        if(countryDto.getId() != null) {
            country.setId(country.getId());
        }
        if(countryDto.getName() != null) {
            country.setName(countryDto.getName());
        }
        if(countryDto.getDescription() != null) {
            country.setDescription(countryDto.getDescription());
        }
        return country;
    }

}
