package com.ratnesh.linkedinproject.userservice.service;

import com.ratnesh.linkedinproject.userservice.dto.LoginRequest;
import com.ratnesh.linkedinproject.userservice.dto.SignupRequest;
import com.ratnesh.linkedinproject.userservice.dto.UserProfileResponse;

public interface AuthService {
    UserProfileResponse signup(SignupRequest request);

    String login(LoginRequest request);
}
