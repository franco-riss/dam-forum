package com.damforum.controller;

import com.damforum.service.iservice.IVoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/votes")
public class VoteController {
    @Autowired
    private IVoteService voteService;

}