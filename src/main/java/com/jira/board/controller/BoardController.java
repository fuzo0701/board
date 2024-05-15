package com.jira.board.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
import com.jira.board.service.BoardService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;





@RestController
@RequestMapping("/api/v1/board")
@RequiredArgsConstructor
@Slf4j
public class BoardController {
    
    private final BoardService boardService;

    @PostMapping("")
    public ResponseEntity<? super PostBoardResponseDto> postBoard(
        @RequestBody @Valid PostBoardRequestDto requestBody,  
        @AuthenticationPrincipal String email) 
    {
        log.debug("PostController : " + requestBody.getBoardImageList().toString());
        ResponseEntity<? super PostBoardResponseDto> response = boardService.postBoard(requestBody, email);
        return response;
    }

    @GetMapping("/{boardNumber}")
    public ResponseEntity<? super GetBoardResponseDto> getBoard(
        @PathVariable("boardNumber") Integer boardNumber
        ) 
    {
        ResponseEntity<? super GetBoardResponseDto> response = boardService.getBoard(boardNumber);
        return response;
    }

    @GetMapping("/{boardNumber}/favorite-list")
    public ResponseEntity<? super GetFavoriteListResponseDto> getFavoiteList(
        @PathVariable("boardNumber") Integer boardNumber
        ) 
    {
        ResponseEntity<? super GetFavoriteListResponseDto> response = boardService.getFavoriteList(boardNumber);
        return response;
    }
    
    @PutMapping("/{boardNumber}/favorite")
    public ResponseEntity<? super PutFavoriteResponseDto> putFavorite(
        @PathVariable("boardNumber") Integer boardNumber, 
        @AuthenticationPrincipal String email) 
    {        
        ResponseEntity<? super PutFavoriteResponseDto> response = boardService.putFavorite(boardNumber, email);
        return response;
    }

    @PostMapping("/{boardNumber}/comment")
    public ResponseEntity<? super PostCommentResponseDto> postComment(
        @RequestBody @Valid PostCommentRequestDto responseBody,
        @PathVariable("boardNumber") Integer boardNumber,
        @AuthenticationPrincipal String email
    ) 
    {
        ResponseEntity<? super PostCommentResponseDto> response = boardService.postComment(responseBody, boardNumber, email);
        return response;
    }

    @GetMapping("/{boardNumber}/comment-list")
    public ResponseEntity<? super GetCommentListReponseDto> getCommentList(
        @PathVariable("boardNumber") Integer boardNumber ) 
    {
        ResponseEntity<? super GetCommentListReponseDto> response = boardService.getCommentList(boardNumber);
        return response;
    }
    
    
    @GetMapping("/{boardNumber}/increase-view-count")
    public ResponseEntity<? super IncreaseViewCountResponseDto> increaseViewCount( @PathVariable("boardNumber") Integer boardNumber){
        ResponseEntity<? super IncreaseViewCountResponseDto> response = boardService.increaseViewCount(boardNumber);
        return response;
    }


    @RequestMapping(value = "/{boardNumber}", method = RequestMethod.DELETE)
    public ResponseEntity<? super DeleteBoardResponseDto> deleteBoard(
        @PathVariable("boardNumber") Integer boardNumber,
        @AuthenticationPrincipal String email
    ){
        ResponseEntity<? super DeleteBoardResponseDto> response = boardService.deleteBoard(boardNumber, email);
        return response;
    }

    @PatchMapping("/{boardNumber}")
    public ResponseEntity<? super PatchBoardResponseDto> patchBoard(
        @RequestBody @Valid PatchBoardRequestDto requestBdoy,
        @PathVariable("boardNumber") Integer boardNumber,
        @AuthenticationPrincipal String email
    ){
        ResponseEntity<? super PatchBoardResponseDto> response = boardService.patchBoard(requestBdoy, boardNumber, email);
        return response;
    }

    @GetMapping("/latest-list")
    public ResponseEntity<? super GetLatestBoardListResponseDto> getLatestBoardList() {
        ResponseEntity<? super GetLatestBoardListResponseDto> response = boardService.getLatestBoardList();
        return response;
    }

    @GetMapping("/top-3")
    public ResponseEntity<? super GetTop3BoardListResponseDto> getTop3BoardList() {
        ResponseEntity<? super GetTop3BoardListResponseDto> response = boardService.getTop3BoardList();
        return response;
    }

    @GetMapping(value = {"/search-list/{searchWord}","/search-list/{searchWord}/{preSearchWord}"})
    public ResponseEntity<? super GetSearchBoardListResponseDto> getSearchBoardList(
        @PathVariable("searchWord") String searchWord,
        @PathVariable(value="preSearchWord", required = false) String preSearchWord
    ) {
        ResponseEntity<? super GetSearchBoardListResponseDto> response = boardService.getSearchBoardList(searchWord, preSearchWord);
        return response;
    }

    @GetMapping("/user-board-list/{email}")
    public ResponseEntity<? super GetUserBoardListResponseDto> getUserBoardList(@PathVariable("email") String email) {
        ResponseEntity<? super GetUserBoardListResponseDto> response = boardService.getUserBoardList(email);
        return response;
    }
    
    
    
}
