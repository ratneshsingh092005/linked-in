package com.ratnesh.linkedinproject.post_service.service;


import com.ratnesh.linkedinproject.post_service.dto.PostCreateRequestDto;
import com.ratnesh.linkedinproject.post_service.dto.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostCreateRequestDto postCreateRequestDto);

    PostDto getPostById(Long postId);

    List<PostDto> getAllPostsOfUser(Long userId);
}
