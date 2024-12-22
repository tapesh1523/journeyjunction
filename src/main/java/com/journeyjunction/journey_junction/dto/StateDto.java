package com.journeyjunction.journey_junction.dto;

import com.journeyjunction.journey_junction.entities.Country;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StateDto {

    private Long id;
    private String name;
    private String description;
    private Long countryId;
}
