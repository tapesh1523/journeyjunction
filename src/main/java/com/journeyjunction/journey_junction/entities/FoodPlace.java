package com.journeyjunction.journey_junction.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.locationtech.jts.geom.Point;

import java.util.Set;

@Entity
@Getter
@Setter
public class FoodPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @ElementCollection
    @CollectionTable(name = "food_place_image", joinColumns = @JoinColumn(name = "food_place_id"))
    @Column(name = "image_url")
    private Set<String> images;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;


    @ManyToMany
    @JoinTable(
            name = "food_tags",
            joinColumns = @JoinColumn(name = "food_place_id"),
            inverseJoinColumns = @JoinColumn(name = "place_tag_id")
    )
    private Set<PlaceTag> tags;

    private String category;

    @Column(columnDefinition = "Geometry(Point, 4326)")
    private Point location;

}
