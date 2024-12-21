package com.journeyjunction.journey_junction.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.locationtech.jts.geom.Point;

@Entity
@Getter
@Setter
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "state_id")
    private State state;

    private String crowded_month;

    private String time_to_visit;

    private String airport;

    private String rlwy_station;

    private String bus_station;

    private String duration;

    @Column(columnDefinition = "Geometry(Point, 4326)")
    private Point location;
}
