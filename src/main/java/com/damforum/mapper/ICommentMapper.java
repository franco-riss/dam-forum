package com.damforum.mapper;

import com.damforum.model.dto.CommentRequestDto;
import com.damforum.model.dto.CommentResponseDto;
import com.damforum.model.entity.CommentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ICommentMapper {
    CommentEntity requestDtoToEntity(CommentRequestDto commentRequestDto);
    @Mapping(target = "postId", source = "postEntity.postId")
    @Mapping(target = "username", source = "userEntity.username")
    CommentResponseDto entityToResponseDto(CommentEntity commentEntity);
}