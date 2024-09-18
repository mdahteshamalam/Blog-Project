package com.blogapp111.service;

import com.blogapp111.dto.CommentDto;
import com.blogapp111.dto.PostDto;
import com.blogapp111.dto.PostWithCommentDto;

import java.util.List;

public interface CommentService {
    CommentDto createComment(CommentDto commentDto,long postId);
    public PostWithCommentDto getAllCommetsByPostId(long id);
  //  public CommentDto getCommentsById(long id);
}
