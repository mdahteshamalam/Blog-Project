package com.blogapp111.controller;

import com.blogapp111.dto.ListPostDto;
import com.blogapp111.dto.PostDto;
import com.blogapp111.service.PostService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/posts")
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
   // http://localhost:1015/api/posts
    @PostMapping
    public ResponseEntity<?> createPost(@Valid @RequestBody PostDto postDto, BindingResult bindingResult){
//        if(postDto.getTitle().length()<3){
//            return new ResponseEntity<>("Title should be atleast three characters",HttpStatus.INTERNAL_SERVER_ERROR);
//        }
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getFieldError().getDefaultMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        PostDto dto = postService.createPost(postDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
   // http://localhost:1015/api/posts/1
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable long id){
     postService.deletePost(id);
     return new ResponseEntity<>("Post is deleted",HttpStatus.OK);
    }
    // http://localhost:1015/api/posts?pageNo=0&pageSize=2&sortBy=description&sortDir=desc
    @GetMapping
    public ListPostDto fetchallPost(
            @RequestParam(name = "pageNo",defaultValue = "0",required = false)int pageNo,
            @RequestParam(name = "pageSize",defaultValue = "5",required = false)int pageSize,
            @RequestParam(name = "sortBy",defaultValue = "id",required = false)String sortBy,
            @RequestParam(name = "sortDir",defaultValue = "asc",required = false)String sortDir

    ){
        ListPostDto listPostDto = postService.fetchallPost(pageNo,pageSize,sortBy,sortDir);
        return listPostDto;
    }
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable long id){
        PostDto postById = postService.getPostById(id);
        return new ResponseEntity<>(postById,HttpStatus.OK);
    }
}
