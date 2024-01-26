package com.damforum.service;

import com.damforum.mapper.ICommunityMapper;
import com.damforum.model.dto.CommunityRequestDto;
import com.damforum.model.dto.CommunityResponseDto;
import com.damforum.model.entity.CommunityEntity;
import com.damforum.repository.ICommunityRepository;
import com.damforum.service.iservice.ICommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class CommunityService implements ICommunityService {
    @Autowired
    private ICommunityRepository communityRepository;
    @Autowired
    private ICommunityMapper communityMapper;

    // CREATE
    public CommunityResponseDto createCommunity(CommunityRequestDto communityRequestDto) {
        CommunityEntity save = communityRepository.save(communityMapper.dtoRequestToEntity(communityRequestDto));
        return communityMapper.entityToDtoResponse(save);
    }

    // READ
    public CommunityResponseDto readCommunity(Long id) {
        CommunityEntity community = communityRepository.findById(id).orElse(null);
        return communityMapper.entityToDtoResponse(community);
    }

    public List<CommunityResponseDto> readCommunities() {
        return communityRepository.findAll()
                .stream()
                .map(communityMapper::entityToDtoResponse)
                .collect(toList());
    }
}