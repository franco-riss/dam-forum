package com.damforum.model.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class CommentResponseDto {
    private Long commentId;
    private String text;
    private Instant created;
    private Long postId;
    private String username;
}