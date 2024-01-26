package com.damforum.service;

import com.damforum.repository.IPostRepository;
import com.damforum.service.iservice.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService implements IPostService {
    @Autowired
    private IPostRepository postRepository;
}