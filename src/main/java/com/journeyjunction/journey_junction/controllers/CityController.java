package com.journeyjunction.journey_junction.controllers;

import com.journeyjunction.journey_junction.dto.CityDto;
import com.journeyjunction.journey_junction.services.CityService;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<CityDto> createCity(@RequestBody CityDto cityDto) {
        CityDto createdCity = cityService.createCity(cityDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCity);
    }
    @GetMapping
    public ResponseEntity<List<CityDto>> getAllCities() {
        return ResponseEntity.ok(cityService.getCityList());
    }

    @GetMapping("/{cityId}")
    public ResponseEntity<CityDto> getCity(@PathVariable Long cityId) {
        return ResponseEntity.ok(cityService.getCity(cityId));
    }

    @PutMapping("/{countryId}")
    public ResponseEntity<CityDto> updateCity(@RequestBody CityDto cityDto,@PathVariable Long countryId) {
        CityDto updatedCity = cityService.updateCity(cityDto, countryId);
        return ResponseEntity.ok(updatedCity);
    }

    @DeleteMapping
    public ResponseEntity<CityDto> deleteCity(Long id) {
        cityService.deleteCity(id);
        return ResponseEntity.noContent().build();
    }
}
