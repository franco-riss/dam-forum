package com.damforum.service;

import com.damforum.repository.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    private ICommentRepository commentRepository;

}