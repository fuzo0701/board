package com.jira.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jira.board.entity.ImageEntity;

@Repository
public interface ImageRepository extends JpaRepository<ImageEntity, Integer>{

    List<ImageEntity> findByBoardNumber(Integer boarderNumber);

    @Transactional
    void deleteByBoardNumber(Integer boardNumber);
    
}
