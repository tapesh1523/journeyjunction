package com.journeyjunction.journey_junction.services;

import com.journeyjunction.journey_junction.dto.LoginDto;
import com.journeyjunction.journey_junction.dto.LoginResponseDto;

public interface AuthService {
    LoginResponseDto login(LoginDto loginDto);

    LoginResponseDto refreshToken(String refreshToken);
}
