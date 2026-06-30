package com.ratnesh.linkedinproject.post_service.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

public record PostDto(

    Long id,

    String content,

    Long userId,

    Instant createdAt
)
{}
