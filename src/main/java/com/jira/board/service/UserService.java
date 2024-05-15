package com.jira.board.service;

import org.springframework.http.ResponseEntity;

import com.jira.board.dto.request.user.PatchNicknameRequestDto;
import com.jira.board.dto.request.user.PatchProfileImageRequestDto;
import com.jira.board.dto.response.user.GetSignInInUserReponseDto;
import com.jira.board.dto.response.user.GetUserResponseDto;
import com.jira.board.dto.response.user.PatchNicknameResponseDto;
import com.jira.board.dto.response.user.PatchProfileImageResponseDto;

public interface UserService {

    ResponseEntity<? super GetUserResponseDto> getUser(String email);
    ResponseEntity<? super GetSignInInUserReponseDto> getSignInUser(String email);
    ResponseEntity<? super PatchNicknameResponseDto> patchNickname(PatchNicknameRequestDto dto, String email);
    ResponseEntity<? super PatchProfileImageResponseDto> patchProfileImage(PatchProfileImageRequestDto dto, String email);
}
