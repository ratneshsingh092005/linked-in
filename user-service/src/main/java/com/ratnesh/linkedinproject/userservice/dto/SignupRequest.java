package com.ratnesh.linkedinproject.userservice.dto;

public record SignupRequest(
        String name,
        String email,
        String password
) {
}
