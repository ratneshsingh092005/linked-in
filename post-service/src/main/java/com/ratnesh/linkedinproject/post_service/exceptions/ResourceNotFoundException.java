package com.ratnesh.linkedinproject.post_service.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Getter
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ResourceNotFoundException extends RuntimeException{
    private String resourceName;
    private String resourceId;
}
