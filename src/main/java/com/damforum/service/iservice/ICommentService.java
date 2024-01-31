package com.damforum.service.iservice;

import com.damforum.model.dto.CommentRequestDto;
import com.damforum.model.dto.CommentResponseDto;

import java.util.List;

public interface ICommentService {
    // CREATE
    CommentResponseDto createComment(CommentRequestDto commentRequestDto);

    // READ
    List<CommentResponseDto> readPostComments(Long id);
    List<CommentResponseDto> readUserComments(String username);
}