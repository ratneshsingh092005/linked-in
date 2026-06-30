package com.ratnesh.linkedinproject.post_service.service.impl;

import com.ratnesh.linkedinproject.post_service.entity.Post;
import com.ratnesh.linkedinproject.post_service.entity.PostLike;
import com.ratnesh.linkedinproject.post_service.exceptions.BadRequestException;
import com.ratnesh.linkedinproject.post_service.exceptions.ResourceNotFoundException;
import com.ratnesh.linkedinproject.post_service.repository.PostLikeRepository;
import com.ratnesh.linkedinproject.post_service.repository.PostRepository;
import com.ratnesh.linkedinproject.post_service.service.PostLikeService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostLikeImpl implements PostLikeService {
    private final PostRepository postRepository;
    private final PostLikeRepository postLikeRepository;
    @Override
    public void likePost(Long postId) {
        Long userId = 1L;
         postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("post",postId.toString()));

        boolean alreadyLiked = postLikeRepository.existsByUserIdAndPostId(userId,postId);
        if(alreadyLiked) throw new BadRequestException("Post has already been liked");

        PostLike postLike = PostLike.builder()
                .postId(postId)
                .userId(userId)
                .build();

        postLikeRepository.save(postLike);


    }

    @Transactional
    @Override
    public void unlikePost(Long postId) {

        Long userId = 1L;
        postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("post",postId.toString()));

        boolean liked = postLikeRepository.existsByUserIdAndPostId(userId,postId);
        if(!liked) throw new BadRequestException("Post has not been liked");

        postLikeRepository.deleteByUserIdAndPostId(userId,postId);

    }
}
