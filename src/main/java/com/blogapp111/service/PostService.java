package com.blogapp111.service;

import com.blogapp111.dto.ListPostDto;
import com.blogapp111.dto.PostDto;

public interface PostService {
    public PostDto createPost(PostDto postDto);

    void deletePost(long id);

    ListPostDto fetchallPost(int pageNo, int pageSize, String sortBy, String sortDir);

  public PostDto getPostById(long id);
}
