package com.damforum.service;

import com.damforum.repository.ICommunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommunityService {
    @Autowired
    private ICommunityRepository communityRepository;

}