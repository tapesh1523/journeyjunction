package com.journeyjunction.journey_junction.dto;

import com.journeyjunction.journey_junction.entities.Country;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class StateDto {

    private Long id;
    private String name;
    private String description;
    private Long countryId;

}
