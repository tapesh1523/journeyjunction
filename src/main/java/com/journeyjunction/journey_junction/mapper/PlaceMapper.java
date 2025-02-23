package com.journeyjunction.journey_junction.mapper;

import com.journeyjunction.journey_junction.dto.PlaceDto;
import com.journeyjunction.journey_junction.entities.City;
import com.journeyjunction.journey_junction.entities.Place;
import com.journeyjunction.journey_junction.entities.AttractionType;
import com.journeyjunction.journey_junction.entities.SuitableFor;
import com.journeyjunction.journey_junction.repositories.AttractionTypeRepository;
import com.journeyjunction.journey_junction.repositories.SuitableForRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static com.journeyjunction.journey_junction.mapper.PointMapper.toPoint;
import static com.journeyjunction.journey_junction.mapper.PointMapper.toPointDto;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


@Component
public class PlaceMapper {

    private static AttractionTypeRepository attractionTypeRepository;
    private static SuitableForRepository suitableForRepository;

    public PlaceMapper(AttractionTypeRepository attractionTypeRepository, SuitableForRepository suitableForRepository) {
        PlaceMapper.attractionTypeRepository = attractionTypeRepository;
        PlaceMapper.suitableForRepository = suitableForRepository;
    }
    // Convert Place entity to PlaceDto
    public static PlaceDto toPlaceDto(Place place) {
        return PlaceDto.builder()
                .id(place.getId())
                .name(place.getName())
                .address(place.getAddress())
                .alert(place.getAlert())
                .description(place.getDescription())
                .attractionType(convertAttractionTypeToString(place.getAttractionType()))  // Set AttractionTypes directly from entity
                .bookingProcess(place.getBookingProcess())
                .events(place.getEvents())
                .bookingProcessDesc(place.getBookingProcessDesc())
                .cityId(place.getCity() != null ? place.getCity().getId() : null)  // Map city_id
                .images(place.getImages())
                .rating(place.getRating())
                .timeRange(place.getTimeRange())
                .visitFare(place.getVisitFare())
                .suitableFor(convertSuitableForToString(place.getSuitableFor()))  // Set SuitableFor directly from entity
                .openingRange(place.getOpeningRange())
                .location(toPointDto(place.getLocation()))  // Convert Point to PointDto
                .duration(place.getDuration())
                .build();
    }

    // Convert PlaceDto to Place entity
    public static Place toEntity(PlaceDto placeDto, Place place, City city) {
        if (placeDto.getId() != null) {
            place.setId(placeDto.getId());
        }
        if (placeDto.getName() != null) {
            place.setName(placeDto.getName());
        }
        if (placeDto.getAddress() != null) {
            place.setAddress(placeDto.getAddress());
        }
        if (placeDto.getAlert() != null) {
            place.setAlert(placeDto.getAlert());
        }
        if (placeDto.getDescription() != null) {
            place.setDescription(placeDto.getDescription());
        }
        if (placeDto.getAttractionType() != null) {
            place.setAttractionType(convertAttractionTypeStringToSet(placeDto.getAttractionType()));  // Directly map the set of AttractionTypes
        }
        if (placeDto.getBookingProcess() != null) {
            place.setBookingProcess(placeDto.getBookingProcess());
        }
        if (placeDto.getEvents() != null) {
            place.setEvents(placeDto.getEvents());
        }
        if (placeDto.getBookingProcessDesc() != null) {
            place.setBookingProcessDesc(placeDto.getBookingProcessDesc());
        }
        if (placeDto.getImages() != null) {
            place.setImages(placeDto.getImages());
        }
        if (placeDto.getRating() != null) {
            place.setRating(placeDto.getRating());
        }
        if (placeDto.getTimeRange() != null) {
            place.setTimeRange(placeDto.getTimeRange());
        }
        if (placeDto.getVisitFare() != null) {
            place.setVisitFare(placeDto.getVisitFare());
        }
        if (placeDto.getSuitableFor() != null) {
            place.setSuitableFor(convertSuitableForStringToSet(placeDto.getSuitableFor()));  // Directly map the set of SuitableFor
        }
        if (placeDto.getOpeningRange() != null) {
            place.setOpeningRange(placeDto.getOpeningRange());
        }
        if (placeDto.getLocation() != null) {
            place.setLocation(toPoint(placeDto.getLocation()));  // Convert PointDto to Point
        }
        if (placeDto.getDuration() != null) {
            place.setDuration(placeDto.getDuration());
        }

        // Set the City (if provided in DTO)
        if (city != null) {
            place.setCity(city);  // Set the city reference in the Place entity
        }

        return place;
    }


    public static Set<String> convertAttractionTypeToString(Set<AttractionType> attractionTypes){
        if (attractionTypes == null) {
            return new HashSet<>();
        }
        return attractionTypes.stream().map(AttractionType::getName).collect(Collectors.toSet());
    }

    public static Set<AttractionType> convertAttractionTypeStringToSet(Set<String> attractionTypes){
        if (attractionTypes == null) {
            return new HashSet<>();
        }
        return attractionTypes.stream()
                .map(attractionTypeRepository::findByName)
                .collect(Collectors.toSet());
    }

    public static Set<SuitableFor> convertSuitableForStringToSet(Set<String> suitableFors){
        if (suitableFors == null) {
            return new HashSet<>();
        }
        return suitableFors.stream()
                .map(suitableForRepository::findByName)
                .collect(Collectors.toSet());
    }
    public static Set<String> convertSuitableForToString(Set<SuitableFor> SuitableFors){
        if (SuitableFors == null) {
            return new HashSet<>();
        }
        return SuitableFors.stream().map(SuitableFor::getName).collect(Collectors.toSet());
    }

}
