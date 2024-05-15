package com.jira.board.service;

import org.springframework.http.ResponseEntity;

import com.jira.board.dto.request.board.PatchBoardRequestDto;
import com.jira.board.dto.request.board.PostBoardRequestDto;
import com.jira.board.dto.request.board.PostCommentRequestDto;
import com.jira.board.dto.response.board.DeleteBoardResponseDto;
import com.jira.board.dto.response.board.GetBoardResponseDto;
import com.jira.board.dto.response.board.GetCommentListReponseDto;
import com.jira.board.dto.response.board.GetFavoriteListResponseDto;
import com.jira.board.dto.response.board.GetLatestBoardListResponseDto;
import com.jira.board.dto.response.board.GetSearchBoardListResponseDto;
import com.jira.board.dto.response.board.GetTop3BoardListResponseDto;
import com.jira.board.dto.response.board.GetUserBoardListResponseDto;
import com.jira.board.dto.response.board.IncreaseViewCountResponseDto;
import com.jira.board.dto.response.board.PatchBoardResponseDto;
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
    ResponseEntity<? super DeleteBoardResponseDto>  deleteBoard(Integer boardNumber, String email);
    ResponseEntity<? super PatchBoardResponseDto> patchBoard(PatchBoardRequestDto dto, Integer boardNumber, String email);
    ResponseEntity<? super GetLatestBoardListResponseDto> getLatestBoardList();
    ResponseEntity<? super GetTop3BoardListResponseDto> getTop3BoardList();
    ResponseEntity<? super GetSearchBoardListResponseDto> getSearchBoardList(String searchWord, String preSearchWord);
    ResponseEntity<? super GetUserBoardListResponseDto> getUserBoardList(String email);

}
