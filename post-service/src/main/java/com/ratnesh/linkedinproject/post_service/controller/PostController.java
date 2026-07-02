package com.ratnesh.linkedinproject.post_service.controller;

import com.ratnesh.linkedinproject.post_service.auth.AuthContextHolder;
import com.ratnesh.linkedinproject.post_service.dto.PostCreateRequestDto;
import com.ratnesh.linkedinproject.post_service.dto.PostDto;
import com.ratnesh.linkedinproject.post_service.service.PostService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/core")
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class PostController {

    PostService postService;

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostCreateRequestDto postCreateRequestDto
                                             ) {
        PostDto postDto = postService.createPost(postCreateRequestDto);
        return  ResponseEntity.status(HttpStatus.CREATED).body(postDto);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostDto> getPost(@PathVariable Long postId) {
        PostDto postDto = postService.getPostById(postId);
        return ResponseEntity.ok(postDto);
    }

    @GetMapping("/users/{userId}/allPosts")
    public ResponseEntity<List<PostDto>> getAllPostsOfUser(@PathVariable Long userId) {
        List<PostDto> posts = postService.getAllPostsOfUser(userId);
        return ResponseEntity.ok(posts);
    }
}
