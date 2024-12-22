package com.journeyjunction.journey_junction.controllers;

import com.journeyjunction.journey_junction.advices.ApiResponse;
import com.journeyjunction.journey_junction.dto.SuitableForDto;
import com.journeyjunction.journey_junction.services.SuitableForService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suitable-for")
@RequiredArgsConstructor
public class SuitableForController {

    private final SuitableForService suitableForService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<SuitableForDto>>> getSuitableFor() {
        List<SuitableForDto> suitableForDtos = suitableForService.getAll();
        return ResponseEntity.ok(new ApiResponse<>(suitableForDtos));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<SuitableForDto>> getSuitableFor(@PathVariable Long id) {
        SuitableForDto suitableForDto = suitableForService.getById(id);
        return ResponseEntity.ok(new ApiResponse<>(suitableForDto));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<SuitableForDto>> createSuitableFor(@RequestBody SuitableForDto suitableForDto) {
        SuitableForDto createdSuitableFor = suitableForService.create(suitableForDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(createdSuitableFor));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse<SuitableForDto>> updateSuitableFor(@PathVariable Long id, @RequestBody SuitableForDto suitableForDto) {
        SuitableForDto updatedSuitableFor = suitableForService.update(suitableForDto);
        return ResponseEntity.ok(new ApiResponse<>(updatedSuitableFor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteSuitableFor(@PathVariable Long id) {
        suitableForService.delete(id); // Pass DTO with the ID
        return ResponseEntity.noContent().build();
    }
}
