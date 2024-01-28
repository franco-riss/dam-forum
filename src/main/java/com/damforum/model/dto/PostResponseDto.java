package com.damforum.model.dto;

import lombok.Data;

@Data
public class PostResponseDto {
    private Long postId;
    private String title;
    private String text;
    private String userName;
    private Integer voteCount;
    private Integer commentCount;
    private CommunityResponseDto community;
}