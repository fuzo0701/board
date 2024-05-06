package com.jira.board.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jira.board.dto.response.ResponseDto;
import com.jira.board.dto.response.user.GetSignInInUserReponseDto;
import com.jira.board.entity.UserEntity;
import com.jira.board.repository.UserRepository;
import com.jira.board.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImplement implements UserService{

    private final UserRepository userRepository;

    @Override
    public ResponseEntity<? super GetSignInInUserReponseDto> getSignInUser(String email) {

        UserEntity userEntity = null;

        try {

            userEntity = userRepository.findByEmail(email);
            if(userEntity == null) return GetSignInInUserReponseDto.notExistUser();
            
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetSignInInUserReponseDto.success(userEntity);
    }
    
}
