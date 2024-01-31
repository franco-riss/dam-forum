package com.damforum.service;

import com.damforum.model.VoteType;
import com.damforum.model.dto.VoteRequestDto;
import com.damforum.model.entity.PostEntity;
import com.damforum.model.entity.VoteEntity;
import com.damforum.repository.IPostRepository;
import com.damforum.repository.IVoteRepository;
import com.damforum.service.iservice.IVoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VoteService implements IVoteService {
    @Autowired
    private IVoteRepository voteRepository;
    @Autowired
    private IPostRepository postRepository;
    @Autowired
    private AuthService authService;

    public void vote(VoteRequestDto voteRequestDto) {

        PostEntity post = postRepository.findById(voteRequestDto.getPostId()).orElse(null);
        Optional<VoteEntity> voteByPostAndUser = voteRepository.findByPostEntityAndUserEntity(post, authService.getCurrentUser());

        if (voteByPostAndUser.isPresent() && voteByPostAndUser.get().getVoteType().equals(voteRequestDto.getVoteType())) {
            return;
        }

        if (VoteType.UPVOTE.equals(voteRequestDto.getVoteType())) {
            post.setVoteCount(post.getVoteCount() + 1);
        } else {
            post.setVoteCount(post.getVoteCount() - 1);
        }

        VoteEntity vote = VoteEntity
                .builder()
                .voteType(voteRequestDto.getVoteType())
                .postEntity(post)
                .userEntity(authService.getCurrentUser())
                .build();

        voteRepository.save(vote);
        postRepository.save(post);
    }
}