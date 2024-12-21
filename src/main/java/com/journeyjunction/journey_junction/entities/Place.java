package com.journeyjunction.journey_junction.entities;

import com.journeyjunction.journey_junction.entities.enums.BookingProcess;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.locationtech.jts.geom.Point;

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
    private Long id;
    private String name;
    private String address;
    private String description;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    private String duration;

    @ManyToMany
    @JoinTable(
        name = "place_attraction",
            joinColumns =@JoinColumn(name = "place_id"),
            inverseJoinColumns = @JoinColumn(name = "attraction")
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
    @CollectionTable(name = "place_time_range", joinColumns = @JoinColumn(name = "place_id"))
    @Column(name = "time_range")
    private Set<String> timeRange;

    @ElementCollection
    @CollectionTable(name = "place_opening_range", joinColumns = @JoinColumn(name = "place_id"))
    @Column(name = "opening_hrs")
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

    @Column(columnDefinition = "Geometry(Point, 4326)")
    private Point location;

}
