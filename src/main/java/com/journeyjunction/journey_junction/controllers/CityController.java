package com.journeyjunction.journey_junction.controllers;

import com.journeyjunction.journey_junction.advices.ApiResponse;
import com.journeyjunction.journey_junction.dto.CityDto;
import com.journeyjunction.journey_junction.services.CityService;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Point;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
@RequiredArgsConstructor
public class CityController {
    private final CityService cityService;

    @PostMapping
    public ResponseEntity<ApiResponse<CityDto>> createCity(@RequestBody CityDto cityDto) {
        CityDto createdCity = cityService.createCity(cityDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(createdCity));
    }
    @GetMapping
    public ResponseEntity<ApiResponse<List<CityDto>>> getAllCities() {
        return ResponseEntity.ok(new ApiResponse<>(cityService.getCityList()));
    }

    @GetMapping("/{cityId}")
    public ResponseEntity<ApiResponse<CityDto>> getCity(@PathVariable Long cityId) {
        return ResponseEntity.ok(new ApiResponse<>(cityService.getCity(cityId)));
    }

    @PutMapping("/{countryId}")
    public ResponseEntity<ApiResponse<CityDto>> updateCity(@RequestBody CityDto cityDto,@PathVariable Long countryId) {
        CityDto updatedCity = cityService.updateCity(cityDto, countryId);
        return ResponseEntity.ok(new ApiResponse<>(updatedCity));
    }

    @DeleteMapping
    public ResponseEntity<CityDto> deleteCity(Long id) {
        cityService.deleteCity(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/nearby/{latitude}/{longitude}/{distanceInKm}")
    public ResponseEntity<ApiResponse<List<CityDto>>> getNearestCities(@PathVariable double latitude, @PathVariable double longitude, @PathVariable double distanceInKm) {
        Point point = cityService.createPoint(latitude, longitude);
        List<CityDto> nearByCities = cityService.findNearestCities(point, distanceInKm);
        return ResponseEntity.ok(new ApiResponse<>(nearByCities));
    }
}
