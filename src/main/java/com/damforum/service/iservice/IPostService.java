package com.damforum.service.iservice;

import com.damforum.model.dto.PostRequestDto;
import com.damforum.model.dto.PostResponseDto;

import java.util.List;

public interface IPostService {
    // CREATE
    PostResponseDto createPost(PostRequestDto postRequestDto);

    // READ
    PostResponseDto readPost(Long id);
    List<PostResponseDto> readPosts();
}