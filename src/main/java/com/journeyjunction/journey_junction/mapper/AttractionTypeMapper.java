package com.journeyjunction.journey_junction.mapper;

import com.journeyjunction.journey_junction.dto.AttractionTypeDto;
import com.journeyjunction.journey_junction.entities.AttractionType;

public class AttractionTypeMapper {
    public static AttractionTypeDto toDto(AttractionType attractionType) {
        return AttractionTypeDto.builder()
                .id(attractionType.getId())
                .name(attractionType.getName())
                .build();
    }

    public static AttractionType toEntity(AttractionTypeDto attractionTypeDto, AttractionType attractionType) {
        if(attractionTypeDto.getId() != null) {
            attractionType.setId(attractionTypeDto.getId());
        }
        if(attractionTypeDto.getName() != null) {
            attractionType.setName(attractionTypeDto.getName());
        }
        return attractionType;
    }
}
