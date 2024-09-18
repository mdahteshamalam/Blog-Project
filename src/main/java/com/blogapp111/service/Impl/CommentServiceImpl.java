package com.blogapp111.service.Impl;

import com.blogapp111.dto.CommentDto;
import com.blogapp111.dto.PostDto;
import com.blogapp111.dto.PostWithCommentDto;
import com.blogapp111.entity.Comment;
import com.blogapp111.entity.Post;
import com.blogapp111.repository.CommentRepository;
import com.blogapp111.repository.PostRepository;
import com.blogapp111.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
//@AllArgsConstructor
public class CommentServiceImpl implements CommentService {
    private CommentRepository commentRepository;
    private ModelMapper modelMapper;
    private PostRepository postRepository;

    public CommentServiceImpl(CommentRepository commentRepository, ModelMapper modelMapper, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.modelMapper = modelMapper;
        this.postRepository = postRepository;
    }

    @Override
    public CommentDto createComment(CommentDto commentDto,long postId) {

        Optional<Post> byId = postRepository.findById(postId);
        Post post = byId.get();

        Comment comment = mapToEntity(commentDto);
        comment.setPost(post);
        Comment savedComment = commentRepository.save(comment);
        CommentDto dto = mapToDto(savedComment);
        return dto;
    }

    @Override
    public PostWithCommentDto getAllCommetsByPostId(long id) {
        Optional<Post> byId = postRepository.findById(id);
        Post post = byId.get();

        //this is for List of comments
        List<Comment> comments= commentRepository.findByPostId(id);
        List<CommentDto> dtos = comments.stream().map(c -> mapToDto(c)).collect(Collectors.toList());


         //this is for List of comments with post




        PostWithCommentDto postWithCommentDto=new PostWithCommentDto();
        postWithCommentDto.setCommnetDto(dtos);
        postWithCommentDto.setPost(post);

        return postWithCommentDto;

    }



    Comment mapToEntity(CommentDto dto){
       Comment comment = modelMapper.map(dto, Comment.class);
       return comment;
   }
   CommentDto mapToDto(Comment comment){
       CommentDto dto = modelMapper.map(comment, CommentDto.class);
       return dto;
   }
//    @Override
//    public CommentDto getCommentsById(long id) {
//        List<Comment> byPostId = commentRepository.findByPostId(id);
//
//    }
}
