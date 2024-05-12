package com.jira.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jira.board.entity.CommentEntity;
import com.jira.board.repository.resultSet.GetCommentListResultSet;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Integer>{

    @Query(
        value = 
        "SELECT U.nickname as nickname " +
            ", U.profile_image as profileImage " +
            ", C.write_datetime as writeDatetime " +
            ", C.content as content " +
        "FROM comment as C " +
        "INNER JOIN user AS U " + 
        "ON C.user_email = U.email " +
        "WHERE C.board_number = ?1 " + 
        "ORDER BY write_datetime DESC",
        nativeQuery = true
    )
    List<GetCommentListResultSet> getCommentList(Integer boardNumber);

    @Transactional
    void deleteByBoardNumber(Integer boardNumber);
}
