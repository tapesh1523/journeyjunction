package com.journeyjunction.journey_junction.controllers;

import com.journeyjunction.journey_junction.advices.ApiResponse;
import com.journeyjunction.journey_junction.dto.PlaceDto;
import com.journeyjunction.journey_junction.entities.Place;
import com.journeyjunction.journey_junction.services.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/place")
@RequiredArgsConstructor
public class PlaceController {

    private final PlaceService placeService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<PlaceDto>>> getPlaces() {
        return ResponseEntity.ok(new ApiResponse<>(placeService.getPlaces()));
    }

    @GetMapping("/{placeId}")
    public ResponseEntity<ApiResponse<PlaceDto>> getPlace(@PathVariable Long placeId) {
        return ResponseEntity.ok(new ApiResponse<>(placeService.getPlace(placeId)));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<PlaceDto>> createPlace(@RequestBody PlaceDto placeDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(placeService.create(placeDto)));
    }

    @PatchMapping("/{placeId}")
    public ResponseEntity<ApiResponse<PlaceDto>> updatePlace(@PathVariable Long placeId, @RequestBody PlaceDto placeDto) {
        return ResponseEntity.ok(new ApiResponse<>(placeService.update(placeDto, placeId)));
    }

    @DeleteMapping("/{placeId}")
    public ResponseEntity<ApiResponse<Void>> deletePlace(@PathVariable Long placeId) {
        placeService.delete(placeId);
        return ResponseEntity.noContent().build();
    }
}
