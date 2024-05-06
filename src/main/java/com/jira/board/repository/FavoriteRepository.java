package com.jira.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jira.board.entity.FavoriteEntity;
import com.jira.board.entity.primaryKey.FavoritePk;
import com.jira.board.repository.resultSet.GetFavoriteListResultSet;

public interface FavoriteRepository extends JpaRepository<FavoriteEntity, FavoritePk> {
    FavoriteEntity findByBoardNumberAndUserEmail(Integer boardNumber, String userEmail);

    @Query(
        value = 
        "SELECT U.email as email " +
            ", U.nickname as nickname " +
            ", U.profile_image as profileImage " +
        "FROM favorite as F " +
        "INNER JOIN user AS U " +
        "ON F.user_email = U.email " +
        "WHERE F.board_number = ?1 ",
        nativeQuery = true
    )
    List<GetFavoriteListResultSet> getFavoriteList(Integer boardNumber);
    
}
