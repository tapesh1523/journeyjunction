package com.journeyjunction.journey_junction.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.journeyjunction.journey_junction.utils.PointSerializer;
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

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "state_id", nullable = false)
    private State state;

    @Column(nullable = false)
    private String crowdedMonth;

    @Column(nullable = false)
    private String timeToVisit;

    @Column(nullable = false)
    private String airport;

    @Column(nullable = false)
    private String railwayStation;

    @Column(nullable = false)
    private String busStation;

    @Column(nullable = false)
    private String duration;

    @Column(columnDefinition = "Geometry(Point, 4326)", nullable = false)
    @JsonSerialize(using = PointSerializer.class)
    private Point location;
}
