package com.blogapp111.dto;

import java.util.List;

public class ListPostDto {
    private List<PostDto> postDto;
    private int totalPage;
    private int totalElement;
    private boolean lastPage;
    private boolean firstPage;
    private int pageNumber;

    public List<PostDto> getPostDto() {
        return postDto;
    }

    public void setPostDto(List<PostDto> postDto) {
        this.postDto = postDto;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalElement() {
        return totalElement;
    }

    public void setTotalElement(int totalElement) {
        this.totalElement = totalElement;
    }

    public boolean isLastPage() {
        return lastPage;
    }

    public void setLastPage(boolean lastPage) {
        this.lastPage = lastPage;
    }

    public boolean isFirstPage() {
        return firstPage;
    }

    public void setFirstPage(boolean firstPage) {
        this.firstPage = firstPage;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
}
