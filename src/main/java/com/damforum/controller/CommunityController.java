package com.damforum.controller;

import com.damforum.model.dto.CommunityRequestDto;
import com.damforum.model.dto.CommunityResponseDto;
import com.damforum.service.iservice.ICommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/communities")
public class CommunityController {
    @Autowired
    private ICommunityService communityService;

    // POST
    @PostMapping
    public ResponseEntity<CommunityResponseDto> postCommunity(@RequestBody CommunityRequestDto communityRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(communityService.createCommunity(communityRequestDto));
    }

    // GET
    @GetMapping("/{id}")
    public ResponseEntity<CommunityResponseDto> getCommunity(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(communityService.readCommunity(id));
    }
    @GetMapping
    public ResponseEntity<List<CommunityResponseDto>> getCommunities() {
        return ResponseEntity.status(HttpStatus.OK).body(communityService.readCommunities());
    }
}