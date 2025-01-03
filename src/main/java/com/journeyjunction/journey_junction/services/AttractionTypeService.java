package com.journeyjunction.journey_junction.services;

import com.journeyjunction.journey_junction.dto.AttractionTypeDto;

import java.util.List;

public interface AttractionTypeService {
    AttractionTypeDto create(AttractionTypeDto attractionTypeDto);
    AttractionTypeDto update(Long id, AttractionTypeDto attractionTypeDto);
    List<AttractionTypeDto> getAll();
    AttractionTypeDto get(long id);
    void delete(long id);
}
