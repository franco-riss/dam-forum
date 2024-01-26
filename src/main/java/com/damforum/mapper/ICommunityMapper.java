package com.damforum.mapper;

import com.damforum.model.dto.CommunityRequestDto;
import com.damforum.model.dto.CommunityResponseDto;
import com.damforum.model.entity.CommunityEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ICommunityMapper {

    CommunityResponseDto entityToDtoResponse(CommunityEntity communityEntity);
    CommunityEntity dtoRequestToEntity(CommunityRequestDto communityRequestDto);
}