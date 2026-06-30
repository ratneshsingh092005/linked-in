package com.ratnesh.linkedinproject.post_service.exceptions;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message) {
        super(message);
    }

}