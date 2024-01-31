package com.damforum.service;

import com.damforum.mapper.ICommentMapper;
import com.damforum.model.dto.CommentRequestDto;
import com.damforum.model.dto.CommentResponseDto;
import com.damforum.model.entity.CommentEntity;
import com.damforum.model.entity.PostEntity;
import com.damforum.model.entity.UserEntity;
import com.damforum.repository.ICommentRepository;
import com.damforum.repository.IPostRepository;
import com.damforum.repository.IUserRepository;
import com.damforum.service.iservice.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class CommentService implements ICommentService {
    @Autowired
    private ICommentRepository commentRepository;
    @Autowired
    private IPostRepository postRepository;
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private AuthService authService;
    @Autowired
    private ICommentMapper commentMapper;

    public CommentResponseDto createComment(CommentRequestDto commentRequestDto) {
        PostEntity post = postRepository.findById(commentRequestDto.getPostId()).orElse(null);
        UserEntity user = authService.getCurrentUser();

        CommentEntity comment = commentMapper.requestDtoToEntity(commentRequestDto);

        comment.setPostEntity(post);
        comment.setUserEntity(user);
        comment.setCreated(java.time.Instant.now());

        return commentMapper.entityToResponseDto(commentRepository.save(comment));
    }

    public List<CommentResponseDto> readPostComments(Long postId) {
        PostEntity post = postRepository.findById(postId).orElse(null);
        return commentRepository.findAllByPostEntity(post).stream().map(commentMapper::entityToResponseDto).collect(toList());
    }

    public List<CommentResponseDto> readUserComments(String username) {
        UserEntity user = userRepository.findByUsername(username).orElse(null);
        return commentRepository.findAllByUserEntity(user).stream().map(commentMapper::entityToResponseDto).collect(toList());
    }
}