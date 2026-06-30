package com.ratnesh.linkedinproject.post_service.service;

import com.ratnesh.linkedinproject.post_service.entity.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PostLikeService {
    void likePost(Long postId);

    void unlikePost(Long postId);
}
