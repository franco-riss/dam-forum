package com.damforum.service;

import com.damforum.jwt.JwtService;
import com.damforum.model.Role;
import com.damforum.model.dto.AuthResponseDto;
import com.damforum.model.dto.LoginRequestDto;
import com.damforum.model.dto.SignupRequestDto;
import com.damforum.model.entity.UserEntity;
import com.damforum.repository.IUserRepository;
import com.damforum.service.iservice.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IAuthService {
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    public AuthResponseDto login(LoginRequestDto request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user = userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.getToken(user);

        return AuthResponseDto
                .builder()
                .token(token)
                .build();
    }

    public AuthResponseDto signup(SignupRequestDto request) {
        UserEntity user = UserEntity
                .builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
                .role(Role.USER)
                .build();

        user.setCreated(java.time.Instant.now());
        userRepository.save(user);

        return AuthResponseDto
                .builder()
                .token(jwtService.getToken(user))
                .build();
    }

    public UserEntity getCurrentUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User name not found - " + username));
    }
}