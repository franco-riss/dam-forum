package com.damforum.mapper;

import com.damforum.model.dto.PostRequestDto;
import com.damforum.model.dto.PostResponseDto;
import com.damforum.model.entity.PostEntity;
import com.damforum.repository.ICommentRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Context;

@Mapper(componentModel = "spring")
public interface IPostMapper {
    @Mapping(target = "community", source = "communityEntity")
    @Mapping(target = "commentCount", expression = "java(commentRepository.countByPostEntity(postEntity))")
    PostResponseDto entityToDtoResponse(PostEntity postEntity, @Context ICommentRepository commentRepository);
    PostEntity dtoRequestToEntity(PostRequestDto postRequestDto);
}