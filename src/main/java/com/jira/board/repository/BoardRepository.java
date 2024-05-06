package com.jira.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jira.board.entity.BoardEntity;
import com.jira.board.repository.resultSet.GetBoardResultSet;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer>{
    
    @Query(
        value = 
        "SELECT B.board_number AS boardNumber " +
            ", B.title  AS title " +
            ", B.content as content " + 
            ", B.write_datetime as writeDatetime " +
            ", B.writer_email as writerEmail " + 
            ", U.nickname as writerNickname " + 
            ", U.profile_image as writerProfileImage " +
        "FROM board AS B " +
        "INNER JOIN user AS U " +
        "ON B.writer_email = U.email " +
        "WHERE board_number = ?1 ",
        nativeQuery = true
    )
    GetBoardResultSet getBoard(Integer boardNumber);

    BoardEntity findByBoardNumber(Integer boardNumber);

    boolean existsByBoardNumber(Integer boardNumber);
}
