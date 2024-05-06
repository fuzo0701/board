package com.jira.board.dto.response.user;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.jira.board.common.ResponseCode;
import com.jira.board.common.ResponseMessage;
import com.jira.board.dto.response.ResponseDto;
import com.jira.board.entity.UserEntity;

import lombok.Getter;

@Getter
public class GetSignInInUserReponseDto extends ResponseDto{

    private String email;
    private String nickname;
    private String profileImage;

    private GetSignInInUserReponseDto(UserEntity userEntity){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.email = userEntity.getEmail();
        this.nickname = userEntity.getNickname();
        this.profileImage = userEntity.getProfileImage();
    }

    public static ResponseEntity<GetSignInInUserReponseDto> success(UserEntity userEntity) {
        GetSignInInUserReponseDto result = new GetSignInInUserReponseDto(userEntity);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistUser(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXISTED_USER, ResponseMessage.NOT_EXISTED_USER);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
    }
}
