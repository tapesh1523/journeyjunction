package com.journeyjunction.journey_junction.entities;

import com.journeyjunction.journey_junction.entities.enums.BookingProcess;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.locationtech.jts.geom.Point;

import javax.validation.constraints.Pattern;
import java.awt.*;
import java.sql.Time;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    private String duration;

    @ManyToMany
    @JoinTable(
            name = "place_attraction",
            joinColumns = @JoinColumn(name = "place_id"),
            inverseJoinColumns = @JoinColumn(name = "attraction_id")  // Corrected column name for attraction type ID
    )
    private Set<AttractionType> attractionType;

    @ElementCollection
    @CollectionTable(name = "place_image", joinColumns = @JoinColumn(name = "place_id"))
    @Column(name = "image_url")
    private Set<String> images;

    private Double visitFare;

    @ManyToMany
    @JoinTable(
            name = "place_suitable",
            joinColumns = @JoinColumn(name = "place_id"),
            inverseJoinColumns = @JoinColumn(name = "suitable_id")
    )
    private Set<SuitableFor> suitableFor;

    @ElementCollection
    @Column(name = "time_range")
    @Pattern(regexp = "^([01]\\d|2[0-3]):([0-5]\\d)\\s*-\\s*([01]\\d|2[0-3]):([0-5]\\d)$",
            message = "Invalid time range format, should be 'HH:mm - HH:mm'")
    private Set<String> timeRange;

    @ElementCollection
    @Column(name = "opening_hrs")
    @Pattern(regexp = "^([01]\\d|2[0-3]):([0-5]\\d)\\s*-\\s*([01]\\d|2[0-3]):([0-5]\\d)$",
            message = "Invalid time range format, should be 'HH:mm - HH:mm'")
    private Set<String> openingRange;

    @Enumerated(EnumType.STRING)
    private BookingProcess bookingProcess;

    private String bookingProcessDesc;

    private Double rating;

    private String alert;

    @ElementCollection
    @CollectionTable(name = "place_events", joinColumns = @JoinColumn(name = "place_id"))
    @Column(name = "events")
    private Set<String> events;

    @Column(columnDefinition = "Geometry(Point, 4326)", nullable = false)
    private Point location;

}
