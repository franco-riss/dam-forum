package com.damforum.service;

import com.damforum.repository.IVoteRepository;
import com.damforum.service.iservice.IVoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteService implements IVoteService {
    @Autowired
    private IVoteRepository voteRepository;
}