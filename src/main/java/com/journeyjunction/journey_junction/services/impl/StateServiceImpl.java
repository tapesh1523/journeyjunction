package com.journeyjunction.journey_junction.services.impl;

import com.journeyjunction.journey_junction.dto.StateDto;
import com.journeyjunction.journey_junction.entities.Country;
import com.journeyjunction.journey_junction.entities.State;
import com.journeyjunction.journey_junction.exceptions.ResourceNotFoundException;
import com.journeyjunction.journey_junction.mapper.StateMapper;
import com.journeyjunction.journey_junction.repositories.CountryRepository;
import com.journeyjunction.journey_junction.repositories.StateRepository;
import com.journeyjunction.journey_junction.services.CountryService;
import com.journeyjunction.journey_junction.services.StateService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StateServiceImpl implements StateService {
    private final StateRepository stateRepository;
    private final CountryRepository countryRepository;


    @Override
    public StateDto getState(Long stateId) {
        State state = stateRepository.findById(stateId).orElseThrow(ResourceNotFoundException::new);

        return StateMapper.toStateDto(state);

    }

    @Override
    public List<StateDto> getAllStates() {
        List<State> states = stateRepository.findAll();
        return states.stream()
                .map(StateMapper::toStateDto)
                .collect(Collectors.toList());
    }

    @Override
    public StateDto createState(StateDto stateDto) {
        Country country = countryRepository.findById(stateDto.getCountryId()).orElseThrow(ResourceNotFoundException::new);
        State state = StateMapper.toEntity(stateDto, new State(), country);
        State savedState = stateRepository.save(state);

        return StateMapper.toStateDto(savedState);
    }

    @Override
    public StateDto updateState(StateDto stateDto, Long stateId) {
        State state = stateRepository.findById(stateId).orElseThrow(() -> new ResourceNotFoundException("State not found with id " + stateId));
        Country country = countryRepository.findById(stateDto.getCountryId()).orElseThrow(ResourceNotFoundException::new);
        State updatedState = StateMapper.toEntity(stateDto, state, country);
        State savedState = stateRepository.save(updatedState);
        return StateMapper.toStateDto(savedState);
    }

    @Override
    public void deleteState(Long stateId) {
        if(stateRepository.findById(stateId).isPresent()) {
            stateRepository.deleteById(stateId);
        }
        else{
            throw new ResourceNotFoundException("State not found with id " + stateId);
        }
        return;
    }
}
