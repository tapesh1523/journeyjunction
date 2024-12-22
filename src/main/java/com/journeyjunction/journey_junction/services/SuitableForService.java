package com.journeyjunction.journey_junction.services;

import com.journeyjunction.journey_junction.dto.SuitableForDto;

import java.util.List;

public interface SuitableForService {
    SuitableForDto create(SuitableForDto suitableForDto);
    SuitableForDto update(SuitableForDto suitableForDto);
    void delete(Long id);
    SuitableForDto getById(Long id);
    List<SuitableForDto> getAll();
}
