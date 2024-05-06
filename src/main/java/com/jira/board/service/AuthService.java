package com.jira.board.service;

import org.springframework.http.ResponseEntity;

import com.jira.board.dto.request.auth.SignInRequestDto;
import com.jira.board.dto.request.auth.SignUpRequestDto;
import com.jira.board.dto.response.auth.SignInResponseDto;
import com.jira.board.dto.response.auth.SignUpResponseDto;

public interface AuthService {
    
    ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto);
    ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto);
}
