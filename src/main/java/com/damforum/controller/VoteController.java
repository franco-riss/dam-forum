package com.damforum.controller;

import com.damforum.model.dto.VoteRequestDto;
import com.damforum.service.iservice.IVoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/votes")
public class VoteController {
    @Autowired
    private IVoteService voteService;

    @PostMapping
    public ResponseEntity<Void> vote(@RequestBody VoteRequestDto voteRequestDto) {
        voteService.vote(voteRequestDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}