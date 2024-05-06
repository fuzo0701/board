package com.jira.board.dto.response.board;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.jira.board.common.ResponseCode;
import com.jira.board.common.ResponseMessage;
import com.jira.board.dto.object.CommentListItem;
import com.jira.board.dto.response.ResponseDto;
import com.jira.board.repository.resultSet.GetCommentListResultSet;

import lombok.Getter;

@Getter
public class GetCommentListReponseDto extends ResponseDto{

    private List<CommentListItem> commentList;

    private GetCommentListReponseDto(List<GetCommentListResultSet> resultSets){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.commentList = CommentListItem.copyList(resultSets);
    }

    public static ResponseEntity<? super GetCommentListReponseDto> success(List<GetCommentListResultSet> resultSets){
        GetCommentListReponseDto result = new GetCommentListReponseDto(resultSets);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> noExistBoard(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXISTED_BOARD, ResponseMessage.NOT_EXISTED_BOARD);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
    
}
