package com.damforum.service;

import com.damforum.repository.ICommentRepository;
import com.damforum.service.iservice.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService implements ICommentService {
    @Autowired
    private ICommentRepository commentRepository;

}