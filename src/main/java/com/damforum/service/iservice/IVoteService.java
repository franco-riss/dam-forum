package com.damforum.service.iservice;

import com.damforum.model.dto.VoteRequestDto;

public interface IVoteService {
    void vote(VoteRequestDto voteRequestDto);
}