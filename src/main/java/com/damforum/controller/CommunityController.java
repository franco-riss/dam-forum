package com.damforum.controller;

import com.damforum.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/communities")
public class CommunityController {
    @Autowired
    private CommunityService communityService;
}