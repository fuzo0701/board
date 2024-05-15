package com.jira.board.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jira.board.dto.request.user.PatchNicknameRequestDto;
import com.jira.board.dto.request.user.PatchProfileImageRequestDto;
import com.jira.board.dto.response.user.GetSignInInUserReponseDto;
import com.jira.board.dto.response.user.GetUserResponseDto;
import com.jira.board.dto.response.user.PatchNicknameResponseDto;
import com.jira.board.dto.response.user.PatchProfileImageResponseDto;
import com.jira.board.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


     @GetMapping("")
     public ResponseEntity<? super GetSignInInUserReponseDto> getSignInUser(@AuthenticationPrincipal String email) {
        ResponseEntity<? super GetSignInInUserReponseDto> response = userService.getSignInUser(email);
        return response;
     }


     @GetMapping("/{email}")
     public ResponseEntity<? super GetUserResponseDto> getUser(@PathVariable("email") String email) {
         ResponseEntity<? super GetUserResponseDto> response = userService.getUser(email);
         return response;
     }

     @PatchMapping("/nickname")
     public ResponseEntity<? super PatchNicknameResponseDto> patchNickname(
        @RequestBody @Valid PatchNicknameRequestDto requestBody,
        @AuthenticationPrincipal String email
     ) {
        ResponseEntity<? super PatchNicknameResponseDto> response = userService.patchNickname(requestBody, email);
        return response;
     }

     @PatchMapping("/profile-image")
     public ResponseEntity<? super PatchProfileImageResponseDto> patchProfileImage(
        @RequestBody @Valid PatchProfileImageRequestDto requestBody,
        @AuthenticationPrincipal String email
     ) {
        
        ResponseEntity<? super PatchProfileImageResponseDto> response = userService.patchProfileImage(requestBody, email);
        return response;
     }
    
}
