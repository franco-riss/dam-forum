package com.damforum.service;

import com.damforum.repository.IVoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteService {
    @Autowired
    private IVoteRepository voteRepository;
}