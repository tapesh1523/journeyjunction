package com.journeyjunction.journey_junction.dto;

import com.journeyjunction.journey_junction.entities.enums.BookingProcess;
import com.journeyjunction.journey_junction.entities.City;
import com.journeyjunction.journey_junction.entities.AttractionType;
import com.journeyjunction.journey_junction.entities.SuitableFor;
import lombok.*;

import java.util.Set;

@Data
@Builder
public class PlaceDto {
    private Long id;
    private String name;
    private String address;
    private String description;
    private Long cityId;
    private String duration;
    private Set<String> attractionType;
    private Set<String> images;
    private Double visitFare;
    private Set<String> suitableFor;
    private Set<String> timeRange;
    private Set<String> openingRange;
    private BookingProcess bookingProcess;
    private String bookingProcessDesc;
    private Double rating;
    private String alert;
    private Set<String> events;
    private PointDto location;
}
