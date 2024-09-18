package com.blogapp111.service.Impl;

import com.blogapp111.dto.ListPostDto;
import com.blogapp111.dto.PostDto;
import com.blogapp111.entity.Post;
import com.blogapp111.exception.ResourceNotFound;
import com.blogapp111.repository.PostRepository;
import com.blogapp111.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;
    private ModelMapper modelMapper;

    public PostServiceImpl(PostRepository postRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
//        Post post=new Post();
//        post.setTitle(postDto.getTitle());
//        post.setDescription(postDto.getDescription());
//        post.setContent(postDto.getContent());

        Post post = mapToEntity(postDto);

        Post savePost = postRepository.save(post);

        PostDto dto = mapToDto(savePost);

//        PostDto dto=new PostDto();
//        dto.setContent(savePost.getContent());
//        dto.setTitle(savePost.getTitle());
//        dto.setDescription(savePost.getDescription());

        return dto;
    }



    Post mapToEntity(PostDto postDto){
        Post post = modelMapper.map(postDto, Post.class);
//        Post post=new Post();
//        post.setTitle(postDto.getTitle());
//        post.setDescription(postDto.getDescription());
//        post.setContent(postDto.getContent());
     return post;
    }
    PostDto mapToDto(Post post){
        PostDto dto = modelMapper.map(post, PostDto.class);
//        PostDto dto=new PostDto();
//        dto.setContent(post.getContent());
//        dto.setTitle(post.getTitle());
//        dto.setDescription(post.getDescription());

        return dto;
    }


    @Override
    public ListPostDto fetchallPost(int pageNo, int pageSize, String sortBy, String sortDir) {
       // List<Post> post = postRepository.findAll();
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Pageable pageable= PageRequest.of(pageNo,pageSize, sort);
        Page<Post> all = postRepository.findAll(pageable);
        List<Post> post = all.getContent();
        List<PostDto> postDto = post.stream().map(p -> mapToDto(p)).collect(Collectors.toList());


        ListPostDto listPostDto=new ListPostDto();

        listPostDto.setPostDto(postDto);
        listPostDto.setTotalPage(all.getTotalPages());
        listPostDto.setTotalElement((int) all.getTotalElements());
        listPostDto.setFirstPage(all.isFirst());
        listPostDto.setLastPage(all.isLast());
        listPostDto.setPageNumber(all.getNumber());


        System.out.println(all.getTotalPages());
        System.out.println(all.getTotalElements());
        System.out.println(all.isFirst());
        System.out.println(all.isLast());

      return listPostDto;
    }
    @Override
    public void deletePost(long id) {
        postRepository.deleteById(id);
    }

    public PostDto getPostById(long id){
     //   Post post = postRepository.findById(id).get();
      // return mapToDto(post);
        Post post = postRepository.findById(id).orElseThrow(
                ()->new ResourceNotFound("post not found with id:"+id)
        );
   return mapToDto(post);
    }

}
