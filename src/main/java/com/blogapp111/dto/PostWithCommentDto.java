package com.blogapp111.dto;

import com.blogapp111.entity.Post;

import java.util.ArrayList;
import java.util.List;

public class PostWithCommentDto {

    private Post post;

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    private List<CommentDto> commnetDto=new ArrayList<>();

    public List<CommentDto> getCommnetDto() {
        return commnetDto;
    }

    public void setCommnetDto(List<CommentDto> commnetDto) {
        this.commnetDto = commnetDto;
    }
    //    private Long id;
//    private String name;
//    private String message;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }


}
