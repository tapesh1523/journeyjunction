package com.journeyjunction.journey_junction.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.locationtech.jts.geom.Point;

import java.awt.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @ElementCollection
    @CollectionTable(name = "todo_image", joinColumns = @JoinColumn(name = "todo_id"))
    @Column(name = "image_url")
    private Set<String> images;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @Column(columnDefinition = "Geometry(Point, 4326)")
    private Point location;

    @ManyToMany
    @JoinTable(
            name = "todo_tags",
            joinColumns = @JoinColumn(name = "todo_id"),
            inverseJoinColumns = @JoinColumn(name = "place_tag_id")
    )
    private Set<PlaceTag> tags;







}
