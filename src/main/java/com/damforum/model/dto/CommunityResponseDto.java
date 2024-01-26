package com.damforum.model.dto;

import lombok.Data;

@Data
public class CommunityResponseDto {
    private Long communityId;
    private String name;
    private String description;
}