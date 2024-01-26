package com.damforum.service.iservice;

import com.damforum.model.dto.CommunityRequestDto;
import com.damforum.model.dto.CommunityResponseDto;

import java.util.List;

public interface ICommunityService {
    // CREATE
    CommunityResponseDto createCommunity(CommunityRequestDto communityRequestDto);

    // READ
    CommunityResponseDto readCommunity(Long id);

    List<CommunityResponseDto> readCommunities();
}