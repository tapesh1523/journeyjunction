package com.journeyjunction.journey_junction.dto;

import com.journeyjunction.journey_junction.entities.State;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;
import org.locationtech.jts.geom.Point;
@Data
@Builder
public class CityDto {
    private Long id;

    private String name;
    private String description;
    private Long stateId;

    private String crowdedMonth;

    private String timeToVisit;

    private String airport;

    private String railwayStation;

    private String busStation;

    private String duration;

    private PointDto location;
}
