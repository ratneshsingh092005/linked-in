package com.ratnesh.linkedinproject.post_service.service.impl;

import com.ratnesh.linkedinproject.post_service.auth.AuthContextHolder;
import com.ratnesh.linkedinproject.post_service.client.ConnectionsServiceClient;
import com.ratnesh.linkedinproject.post_service.dto.PersonDto;
import com.ratnesh.linkedinproject.post_service.dto.PostCreateRequestDto;
import com.ratnesh.linkedinproject.post_service.dto.PostDto;
import com.ratnesh.linkedinproject.post_service.entity.Post;
import com.ratnesh.linkedinproject.post_service.exceptions.ResourceNotFoundException;
import com.ratnesh.linkedinproject.post_service.mapper.PostMapper;
import com.ratnesh.linkedinproject.post_service.repository.PostRepository;
import com.ratnesh.linkedinproject.post_service.service.PostService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class PostServiceImpl implements PostService {

    PostRepository postRepository;
    PostMapper postMapper;
    ConnectionsServiceClient connectionsServiceClient;

    @Override
    public PostDto createPost(PostCreateRequestDto postCreateRequestDto) {
        //// API Gateway parses the JWT and adds the userId to the request header.
        Long userId = AuthContextHolder.getCurrentUserId();

        Post post = Post.builder()
                .userId(userId)
                .content(postCreateRequestDto.content())
                .build();
        post = postRepository.save(post);
        return postMapper.toPostDto(post);
    }

    @Override
    public PostDto getPostById(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("post",postId.toString()));
        Long userId = AuthContextHolder.getCurrentUserId();
//        List<PersonDto> personDtoList = connectionsServiceClient.getFirstDegreeConnections(userId);
        return postMapper.toPostDto(post);
    }

    @Override
    public List<PostDto> getAllPostsOfUser(Long userId) {
        List<Post> posts = postRepository.findAllByUserId(userId);
        return postMapper.toListOfPostDto(posts);
    }
}
