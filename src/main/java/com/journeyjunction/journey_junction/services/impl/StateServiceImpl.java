package com.journeyjunction.journey_junction.services.impl;

import com.journeyjunction.journey_junction.dto.StateDto;
import com.journeyjunction.journey_junction.entities.State;
import com.journeyjunction.journey_junction.exceptions.ResourceNotFoundException;
import com.journeyjunction.journey_junction.repositories.StateRepository;
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
    private final ModelMapper modelMapper;

    @Override
    public StateDto getState(Long stateId) {
        Optional<State> state = stateRepository.findById(stateId);
        if (state.isEmpty()) {
            throw new ResourceNotFoundException("State not found with id " + stateId);
        }
        return modelMapper.map(state, StateDto.class);
    }

    @Override
    public List<StateDto> getAllStates() {
        List<State> states = stateRepository.findAll();
        return states.stream()
                .map(state -> modelMapper.map(state, StateDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public StateDto createState(StateDto stateDto) {
        State state = modelMapper.map(stateDto, State.class);

        return modelMapper.map(stateRepository.save(state), StateDto.class);
    }

    @Override
    public StateDto updateState(StateDto stateDto, Long stateId) {
        State state = stateRepository.findById(stateId).orElseThrow(() -> new ResourceNotFoundException("State not found with id " + stateId));
        stateDto.setId(stateId);
        modelMapper.map(stateDto, state);
        return modelMapper.map(stateRepository.save(state), StateDto.class);
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
