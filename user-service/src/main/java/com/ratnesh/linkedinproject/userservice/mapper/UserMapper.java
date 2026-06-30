package com.ratnesh.linkedinproject.userservice.mapper;

import com.ratnesh.linkedinproject.userservice.dto.UserProfileResponse;
import com.ratnesh.linkedinproject.userservice.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {


    UserProfileResponse toUserProfileResponse(User user);
}
