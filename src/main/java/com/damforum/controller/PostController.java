package com.damforum.controller;

import com.damforum.model.dto.PostRequestDto;
import com.damforum.model.dto.PostResponseDto;
import com.damforum.service.iservice.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
    @Autowired
    private IPostService postService;

    // POST
    @PostMapping
    public ResponseEntity<PostResponseDto> postPost(@RequestBody PostRequestDto postRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(postService.createPost(postRequestDto));
    }

    // GET
    @GetMapping("/{id}")
    public ResponseEntity<PostResponseDto> getPost(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(postService.readPost(id));
    }
    @GetMapping
    public ResponseEntity<List<PostResponseDto>> getPosts() {
        return ResponseEntity.status(HttpStatus.OK).body(postService.readPosts());
    }
}