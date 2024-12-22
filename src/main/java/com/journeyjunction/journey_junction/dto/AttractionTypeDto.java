package com.journeyjunction.journey_junction.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AttractionTypeDto {
    private Long id;
    private String name;
}
