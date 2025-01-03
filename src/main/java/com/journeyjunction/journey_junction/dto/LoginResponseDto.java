package com.journeyjunction.journey_junction.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponseDto {
    private Long id;
    private String accessToken;
    private String refreshToken;
}
