package com.blogapp111.repository;

import com.blogapp111.dto.CommentDto;
import com.blogapp111.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostId(long postId);
}