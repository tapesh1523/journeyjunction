package com.journeyjunction.journey_junction.controllers;

import com.journeyjunction.journey_junction.advices.ApiResponse;
import com.journeyjunction.journey_junction.dto.AttractionTypeDto;
import com.journeyjunction.journey_junction.services.AttractionTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attraction-type")
@RequiredArgsConstructor
public class AttractionTypeController {

    private final AttractionTypeService attractionTypeService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<AttractionTypeDto>>> getAttractionTypes() {
        List<AttractionTypeDto> attractionTypeDtos = attractionTypeService.getAll();
        return ResponseEntity.ok(new ApiResponse<>(attractionTypeDtos));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<AttractionTypeDto>> getAttractionType(@PathVariable Long id) {
        AttractionTypeDto attractionTypeDto = attractionTypeService.get(id);
        return ResponseEntity.ok(new ApiResponse<>(attractionTypeDto));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<AttractionTypeDto>> createAttractionType(@RequestBody AttractionTypeDto attractionTypeDto) {
        AttractionTypeDto createdAttractionType = attractionTypeService.create(attractionTypeDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(createdAttractionType));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse<AttractionTypeDto>> updateAttractionType(@PathVariable Long id, @RequestBody AttractionTypeDto attractionTypeDto) {
        AttractionTypeDto updatedAttractionType = attractionTypeService.update(id,attractionTypeDto);
        return ResponseEntity.ok(new ApiResponse<>(updatedAttractionType));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteAttractionType(@PathVariable Long id) {
        attractionTypeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
