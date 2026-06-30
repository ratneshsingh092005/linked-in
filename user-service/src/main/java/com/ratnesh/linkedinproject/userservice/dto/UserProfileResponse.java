package com.ratnesh.linkedinproject.userservice.dto;

public record UserProfileResponse(
        Long id,
        String email,
        String name
) {
}
