package com.ratnesh.linkedinproject.post_service.repository;

import com.ratnesh.linkedinproject.post_service.entity.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostLikeRepository extends JpaRepository<PostLike,Long> {
    boolean existsByUserIdAndPostId(long userId, Long postId);

    void deleteByUserIdAndPostId(long userId, Long postId);
}
