package com.damforum.service.iservice;

import com.damforum.model.dto.AuthResponseDto;
import com.damforum.model.dto.LoginRequestDto;
import com.damforum.model.dto.SignupRequestDto;

public interface IAuthService {
    AuthResponseDto login(LoginRequestDto request);
    AuthResponseDto signup(SignupRequestDto request);
}