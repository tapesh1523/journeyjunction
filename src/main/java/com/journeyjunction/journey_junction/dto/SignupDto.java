package com.journeyjunction.journey_junction.dto;

import com.journeyjunction.journey_junction.entities.enums.Role;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class SignupDto {
    private String email;
    private String password;
    private String name;
    private Set<Role> roles;
}
