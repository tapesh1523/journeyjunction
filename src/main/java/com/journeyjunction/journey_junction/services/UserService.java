package com.journeyjunction.journey_junction.services;

import com.journeyjunction.journey_junction.dto.LoginDto;
import com.journeyjunction.journey_junction.dto.SignupDto;
import com.journeyjunction.journey_junction.dto.UserDto;
import com.journeyjunction.journey_junction.entities.User;
import com.journeyjunction.journey_junction.exceptions.ResourceNotFoundException;
import com.journeyjunction.journey_junction.mapper.UserMapper;
import com.journeyjunction.journey_junction.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElseThrow(() -> new BadCredentialsException(username));
    }

    public UserDto signUp(SignupDto signupDto) {
        Optional<User> user = userRepository.findByEmail(signupDto.getEmail());
        if (user.isPresent()) {
            throw new BadCredentialsException("Email already in use");
        }
        User newUser = UserMapper.toUser(signupDto, new User());
        newUser.setPassword(passwordEncoder.encode(signupDto.getPassword()));
        User savedUser = userRepository.save(newUser);
        return UserMapper.toUserDto(savedUser);
    }

    public User getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        return user;
    }

    public User getUserByEmail(String email) {
        User user = userRepository.findByEmail(email).orElse(null);
        return user;
    }

    public User save(User user) {
        return userRepository.save(user);
    }


}
