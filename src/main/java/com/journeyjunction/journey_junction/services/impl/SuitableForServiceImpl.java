package com.journeyjunction.journey_junction.services.impl;

import com.journeyjunction.journey_junction.dto.SuitableForDto;
import com.journeyjunction.journey_junction.entities.SuitableFor;
import com.journeyjunction.journey_junction.exceptions.ResourceNotFoundException;
import com.journeyjunction.journey_junction.mapper.SuitableForMapper;
import com.journeyjunction.journey_junction.repositories.SuitableForRepository;
import com.journeyjunction.journey_junction.services.SuitableForService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SuitableForServiceImpl implements SuitableForService {

    private final SuitableForRepository suitableForRepository;

    @Override
    public SuitableForDto create(SuitableForDto suitableForDto) {
        // Convert DTO to entity, save, and convert back to DTO
        SuitableFor suitableFor = SuitableForMapper.toEntity(suitableForDto, new SuitableFor());
        suitableFor = suitableForRepository.save(suitableFor);
        return SuitableForMapper.toDto(suitableFor);
    }

    @Override
    public SuitableForDto update(SuitableForDto suitableForDto) {
        // Check if entity exists before updating
        SuitableFor existingSuitableFor = suitableForRepository.findById(suitableForDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("SuitableFor not found for ID: " + suitableForDto.getId()));

        // Convert DTO to entity and update
        SuitableFor suitableFor = SuitableForMapper.toEntity(suitableForDto, existingSuitableFor);
        suitableFor = suitableForRepository.save(suitableFor);
        return SuitableForMapper.toDto(suitableFor);
    }

    @Override
    public void delete(Long id) {
        // Ensure that the entity exists before attempting to delete
        if (!suitableForRepository.existsById(id)) {
            throw new ResourceNotFoundException("No such SuitableFor type found for ID: " + id);
        }
        suitableForRepository.deleteById(id);
        return;
    }

    @Override
    public SuitableForDto getById(Long id) {
        // Fetch and convert the entity to DTO
        SuitableFor suitableFor = suitableForRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SuitableFor not found for ID: " + id));
        return SuitableForMapper.toDto(suitableFor);
    }

    @Override
    public List<SuitableForDto> getAll() {
        // Fetch all entities and convert to DTOs
        List<SuitableFor> suitableForList = suitableForRepository.findAll();
        return suitableForList.stream()
                .map(SuitableForMapper::toDto)
                .collect(Collectors.toList());
    }
}
