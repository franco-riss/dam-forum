package com.damforum.controller;

import com.damforum.service.iservice.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentsController {
    @Autowired
    private ICommentService commentService;
}
