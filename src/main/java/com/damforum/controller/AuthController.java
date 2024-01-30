package com.damforum.controller;

import com.damforum.model.dto.AuthResponseDto;
import com.damforum.model.dto.LoginRequestDto;
import com.damforum.model.dto.SignupRequestDto;
import com.damforum.service.iservice.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    private IAuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody LoginRequestDto request){
        return ResponseEntity.ok(authService.login(request));
    }
    @PostMapping("/signup")
    public ResponseEntity<AuthResponseDto> signup(@RequestBody SignupRequestDto request){
        return ResponseEntity.ok(authService.signup(request));
    }
}