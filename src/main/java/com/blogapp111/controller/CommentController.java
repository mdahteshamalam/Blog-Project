package com.blogapp111.controller;

import com.blogapp111.dto.CommentDto;
import com.blogapp111.dto.PostWithCommentDto;
import com.blogapp111.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    @PostMapping("/{postId}")
    public ResponseEntity<CommentDto> createComment(
           @RequestBody CommentDto commentDto,
         @PathVariable long postId){
        CommentDto comment = commentService.createComment(commentDto, postId);
        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }
    @GetMapping("/{postId}")
    public ResponseEntity<PostWithCommentDto> getAllCommentsByPostId(@PathVariable long postId){
        PostWithCommentDto postWithCommentDto =commentService.getAllCommetsByPostId(postId);
        return new ResponseEntity<>(postWithCommentDto,HttpStatus.OK);
    }
}
