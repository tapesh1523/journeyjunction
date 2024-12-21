package com.journeyjunction.journey_junction.services;

import com.journeyjunction.journey_junction.dto.StateDto;

import java.util.List;

public interface StateService {
    StateDto getState(Long stateId);
    List<StateDto> getAllStates();
    StateDto createState(StateDto stateDto);
    StateDto updateState(StateDto stateDto, Long stateId);
    void deleteState(Long stateId);

}
