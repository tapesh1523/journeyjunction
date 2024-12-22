package com.journeyjunction.journey_junction.mapper;

import com.journeyjunction.journey_junction.dto.StateDto;
import com.journeyjunction.journey_junction.entities.State;
import com.journeyjunction.journey_junction.entities.Country;

public class StateMapper {


    public static StateDto toStateDto(State state) {
        return StateDto.builder()
                .id(state.getId())
                .name(state.getName())
                .description(state.getDescription())
                .countryId(state.getCountry() != null ? state.getCountry().getId() : null)  // Map countryId from Country entity
                .build();
    }

    public static State toEntity(StateDto stateDto, State state, Country country) {
        // Set the ID if not null (for update scenario)
        if(stateDto.getId() != null) {
            state.setId(stateDto.getId());
        }
        if(stateDto.getName() != null) {
            state.setName(stateDto.getName());
        }
        if(stateDto.getDescription() != null) {
            state.setDescription(stateDto.getDescription());
        }

        // Set the Country (assuming you have a CountryRepository or Country service to fetch the country by ID)
        if (country != null) {
            state.setCountry(country);
        }

        return state;
    }
}
