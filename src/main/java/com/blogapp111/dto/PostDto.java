package com.blogapp111.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class PostDto {
    private long id;
    @NotEmpty
    @Size(min = 3,message = "title should be atleast three characters")
    private String title;
    @NotEmpty
    @Size(min = 3,message = "description should be atleast three characters")
    private String description;
    private String content;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}
