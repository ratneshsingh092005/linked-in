package com.ratnesh.linkedinproject.userservice.dto;

public record LoginRequest(
        String email,
        String password
) {
}
