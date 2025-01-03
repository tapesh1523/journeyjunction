package com.journeyjunction.journey_junction.mapper;

import com.journeyjunction.journey_junction.dto.SignupDto;
import com.journeyjunction.journey_junction.dto.UserDto;
import com.journeyjunction.journey_junction.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public static UserDto toUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }

    public static User toUser(SignupDto userDto, User user) {
        if(userDto.getRoles() != null){
            user.setRoles(userDto.getRoles());
        }
        if(userDto.getName() != null) {
            user.setName(userDto.getName());
        }
        if(userDto.getEmail() != null) {
            user.setEmail(userDto.getEmail());
        }
        if(userDto.getPassword() != null) {
            user.setPassword(userDto.getPassword());
        }
        return user;

    }
}
