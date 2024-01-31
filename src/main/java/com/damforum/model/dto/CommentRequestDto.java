package com.damforum.model.dto;

import lombok.Data;

@Data
public class CommentRequestDto {
    private Long postId;
    private String text;
    private String username;
}