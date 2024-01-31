package com.damforum.controller;

import com.damforum.model.dto.CommentRequestDto;
import com.damforum.model.dto.CommentResponseDto;
import com.damforum.service.iservice.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentsController {
    @Autowired
    private ICommentService commentService;

    // POST
    @PostMapping
    public ResponseEntity<CommentResponseDto> postComment(@RequestBody CommentRequestDto commentRequestDto) {
        return ResponseEntity.status(CREATED).body(commentService.createComment(commentRequestDto));
    }

    // GET
    @GetMapping("/posts/{id}")
    public ResponseEntity<List<CommentResponseDto>> getPostComments(@PathVariable Long id) {
        return ResponseEntity.status(OK).body(commentService.readPostComments(id));
    }
    @GetMapping("/users/{username}")
    public ResponseEntity<List<CommentResponseDto>> getUserComments(@PathVariable String username) {
        return ResponseEntity.status(OK).body(commentService.readUserComments(username));
    }
}