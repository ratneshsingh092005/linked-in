package com.ratnesh.linkedinproject.post_service.mapper;

import com.ratnesh.linkedinproject.post_service.dto.PostDto;
import com.ratnesh.linkedinproject.post_service.entity.Post;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {

    PostDto toPostDto(Post post);

    List<PostDto> toListOfPostDto(List<Post> posts);
}
