package com.journeyjunction.journey_junction.services.impl;

import com.journeyjunction.journey_junction.dto.AttractionTypeDto;
import com.journeyjunction.journey_junction.entities.AttractionType;
import com.journeyjunction.journey_junction.exceptions.ResourceNotFoundException;
import com.journeyjunction.journey_junction.mapper.AttractionTypeMapper;
import com.journeyjunction.journey_junction.repositories.AttractionTypeRepository;
import com.journeyjunction.journey_junction.services.AttractionTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AttractionTypeServiceImpl implements AttractionTypeService {
    private final AttractionTypeRepository attractionTypeRepository;

    @Override
    public AttractionTypeDto create(AttractionTypeDto attractionTypeDto) {
        return AttractionTypeMapper.toDto(attractionTypeRepository.save(AttractionTypeMapper.toEntity(attractionTypeDto, new AttractionType())));
    }

    @Override
    public AttractionTypeDto update(Long id,AttractionTypeDto attractionTypeDto) {
        AttractionType  attractionType = attractionTypeRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        AttractionType updatedAttractionType = AttractionTypeMapper.toEntity(attractionTypeDto, attractionType);
        AttractionType savedAttractionType = attractionTypeRepository.save(updatedAttractionType);
        return AttractionTypeMapper.toDto(savedAttractionType);
    }

    @Override
    public List<AttractionTypeDto> getAll() {
        List<AttractionType> attractionTypes = attractionTypeRepository.findAll();
        return attractionTypes.stream().map(AttractionTypeMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public AttractionTypeDto get(long id) {
        AttractionType attractionType = attractionTypeRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        return AttractionTypeMapper.toDto(attractionType);
    }

    @Override
    public void delete(long id) {
        if(!attractionTypeRepository.existsById(id)) {
            throw new ResourceNotFoundException("No such attraction type");
        }
        attractionTypeRepository.deleteById(id);
        return;
    }
}
