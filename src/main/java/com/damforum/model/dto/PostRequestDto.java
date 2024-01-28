package com.damforum.model.dto;

import lombok.Data;

@Data
public class PostRequestDto {
    private String title;
    private String communityName;
    private String text;
}