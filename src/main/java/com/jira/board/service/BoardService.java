package com.jira.board.service;

import org.springframework.http.ResponseEntity;

import com.jira.board.dto.request.board.PostBoardRequestDto;
import com.jira.board.dto.request.board.PostCommentRequestDto;
import com.jira.board.dto.response.board.GetBoardResponseDto;
import com.jira.board.dto.response.board.GetCommentListReponseDto;
import com.jira.board.dto.response.board.GetFavoriteListResponseDto;
import com.jira.board.dto.response.board.IncreaseViewCountResponseDto;
import com.jira.board.dto.response.board.PostBoardResponseDto;
import com.jira.board.dto.response.board.PostCommentResponseDto;
import com.jira.board.dto.response.board.PutFavoriteResponseDto;

public interface BoardService {
    ResponseEntity<? super GetBoardResponseDto> getBoard(Integer boardNumber);
    ResponseEntity<? super PostBoardResponseDto> postBoard(PostBoardRequestDto dto, String email);
    ResponseEntity<? super PutFavoriteResponseDto> putFavorite(Integer boardNumber, String email);
    ResponseEntity<? super GetFavoriteListResponseDto> getFavoriteList(Integer boardNumber);
    ResponseEntity<? super PostCommentResponseDto> postComment(PostCommentRequestDto dto, Integer boardNumber, String email);
    ResponseEntity<? super GetCommentListReponseDto> getCommentList(Integer boardNumber);

    ResponseEntity<? super IncreaseViewCountResponseDto> increaseViewCount(Integer boardNumber);
}
