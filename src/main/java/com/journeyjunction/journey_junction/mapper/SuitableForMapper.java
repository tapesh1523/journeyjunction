package com.journeyjunction.journey_junction.mapper;

import com.journeyjunction.journey_junction.dto.SuitableForDto;
import com.journeyjunction.journey_junction.entities.SuitableFor;

public class SuitableForMapper {

    public static SuitableForDto toDto(SuitableFor suitableFor) {
        return SuitableForDto.builder()
                .id(suitableFor.getId())
                .name(suitableFor.getName())
                .build();
    }

    public static SuitableFor toEntity(SuitableForDto suitableForDto, SuitableFor sutableFor) {
        if (suitableForDto.getId() != null) {
            sutableFor.setId(suitableForDto.getId());
        }
        if (suitableForDto.getName() != null) {
            sutableFor.setName(suitableForDto.getName());
        }
        return sutableFor;
    }
}
