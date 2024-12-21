package com.journeyjunction.journey_junction.controllers;

import com.journeyjunction.journey_junction.dto.CountryDto;
import com.journeyjunction.journey_junction.services.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
@RequiredArgsConstructor
public class CountryControllers {
    private final CountryService countryService;

    @PostMapping
    public ResponseEntity<CountryDto> createCountry(@RequestBody CountryDto countryDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(countryService.createCountry(countryDto));
    }

    @GetMapping("/{countryId}")
    public ResponseEntity<CountryDto> getCountry(@PathVariable Long countryId) {
        return ResponseEntity.ok(countryService.getCountry(countryId));
    }

    @GetMapping
    public ResponseEntity<List<CountryDto>> getAllCountries() {
        return ResponseEntity.status(HttpStatus.OK).body(countryService.getAllCountries());
    }

    @PutMapping("/{countryId}")
    public ResponseEntity<CountryDto> updateCountry(@RequestBody CountryDto countryDto, @PathVariable Long countryId) {
        return ResponseEntity.status(HttpStatus.OK).body(countryService.updateCountry(countryId, countryDto));

    }
    @DeleteMapping
    public ResponseEntity<CountryDto> deleteCountry(@PathVariable Long countryId) {
        countryService.deleteCountry(countryId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
