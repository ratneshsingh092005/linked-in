package com.ratnesh.linkedinproject.userservice.service.impl;

import com.ratnesh.linkedinproject.userservice.dto.LoginRequest;
import com.ratnesh.linkedinproject.userservice.dto.SignupRequest;
import com.ratnesh.linkedinproject.userservice.dto.UserProfileResponse;
import com.ratnesh.linkedinproject.userservice.entity.User;
import com.ratnesh.linkedinproject.userservice.exceptions.BadRequestException;
import com.ratnesh.linkedinproject.userservice.mapper.UserMapper;
import com.ratnesh.linkedinproject.userservice.repository.UserRepository;
import com.ratnesh.linkedinproject.userservice.service.AuthService;
import com.ratnesh.linkedinproject.userservice.utility.BCrypt;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final JwtService jwtService;
    @Override
    public UserProfileResponse signup(SignupRequest request) {

        userRepository.findByEmail(request.email()).ifPresent(user -> {
            throw new BadRequestException("User already exists with email: "+request.email());
        });
        User user = User.builder()
                .name(request.name())
                .email(request.email())
                .password(BCrypt.hash(request.password()))
                .build();

        user = userRepository.save(user);

        return userMapper.toUserProfileResponse(user);
    }

    @Override
    public String login(LoginRequest request) {

        User user = userRepository.findByEmail(request.email()).orElseThrow(() -> new BadRequestException(
                "Incorrect email or password"));

        boolean isPasswordMatch = BCrypt.match(request.password(),user.getPassword());

        if(!isPasswordMatch) {
            throw new BadRequestException("Incorrect email or password");
        }

        return jwtService.generateAccessToken(user);
    }
}
