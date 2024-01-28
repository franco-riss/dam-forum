package com.damforum.service;

import com.damforum.mapper.IPostMapper;
import com.damforum.model.dto.PostRequestDto;
import com.damforum.model.dto.PostResponseDto;
import com.damforum.model.entity.CommunityEntity;
import com.damforum.model.entity.PostEntity;
import com.damforum.repository.ICommunityRepository;
import com.damforum.repository.IPostRepository;
import com.damforum.repository.ICommentRepository;
import com.damforum.service.iservice.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class PostService implements IPostService {
    @Autowired
    private IPostRepository postRepository;
    @Autowired
    private ICommunityRepository communityRepository;
    @Autowired
    private ICommentRepository commentRepository;
    @Autowired
    private IPostMapper postMapper;

    // CREATE
    public PostResponseDto createPost(PostRequestDto postRequestDto) {

        CommunityEntity community = communityRepository.findByName(postRequestDto.getCommunityName());

        PostEntity post = postMapper.dtoRequestToEntity(postRequestDto);

        post.setCreated(java.time.Instant.now());
        post.setCommunityEntity(community);
        post.setVoteCount(0);

        return postMapper.entityToDtoResponse(postRepository.save(post), commentRepository);
    }

    // READ
    public PostResponseDto readPost(Long id) {
        PostEntity post = postRepository.findById(id).orElse(null);
        return postMapper.entityToDtoResponse(post, commentRepository);
    }

    public List<PostResponseDto> readPosts() {
        return postRepository.findAll()
                .stream()
                .map(post -> postMapper.entityToDtoResponse(post, commentRepository))
                .collect(toList());
    }
}