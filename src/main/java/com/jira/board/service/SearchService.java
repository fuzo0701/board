package com.jira.board.service;

import org.springframework.http.ResponseEntity;

import com.jira.board.dto.response.search.GetPopularListResponseDto;
import com.jira.board.dto.response.search.GetRelationListResponseDto;

public interface SearchService {

  ResponseEntity<? super GetPopularListResponseDto> getPopularList();

  ResponseEntity<? super GetRelationListResponseDto> getRelationList(String searchWord);
} 