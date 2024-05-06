package com.jira.board.service;

import org.springframework.http.ResponseEntity;

import com.jira.board.dto.response.user.GetSignInInUserReponseDto;

public interface UserService {

    ResponseEntity<? super GetSignInInUserReponseDto> getSignInUser(String email);
}
