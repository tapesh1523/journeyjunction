package com.journeyjunction.journey_junction.controllers;

import com.journeyjunction.journey_junction.advices.ApiResponse;
import com.journeyjunction.journey_junction.dto.StateDto;
import com.journeyjunction.journey_junction.services.StateService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/state")
@RequiredArgsConstructor
public class StateController {
    private final StateService stateService;

    @PostMapping
    public ResponseEntity<ApiResponse<StateDto>> createState(@RequestBody StateDto stateDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(stateService.createState(stateDto)));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<StateDto>>> getAllStates() {
        return ResponseEntity.ok(new ApiResponse<>(stateService.getAllStates()));
    }

    @GetMapping("/{stateId}")
    public ResponseEntity<ApiResponse<StateDto>> getState(@PathVariable Long stateId) {
        return ResponseEntity.ok(new ApiResponse<>(stateService.getState(stateId)));
    }

    @PatchMapping("/{stateId}")
    public ResponseEntity<ApiResponse<StateDto>> updateState(@RequestBody StateDto stateDto, @PathVariable Long stateId) {
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(stateService.updateState(stateDto, stateId)));
    }

    @DeleteMapping("/{stateId}")
    public ResponseEntity<StateDto> deleteState(@PathVariable Long stateId) {
        stateService.deleteState(stateId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
