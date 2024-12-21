package com.journeyjunction.journey_junction.dto;

import com.journeyjunction.journey_junction.entities.State;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.locationtech.jts.geom.Point;
@Data
public class CityDto {
    private Long id;

    private String name;
    private String description;
    private State state;

    private String crowded_month;

    private String time_to_visit;

    private String airport;

    private String rlwy_station;

    private String bus_station;

    private String duration;

    private Point location;
}
