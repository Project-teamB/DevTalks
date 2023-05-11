package com.teamproject.devTalks.repository.comment;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teamproject.devTalks.entity.comment.InformationCommentEntity;

public interface InformationCommentRepository extends JpaRepository<InformationCommentEntity, Integer> {
    
    public InformationCommentEntity findByBoardNumber(int informationBoardNumber);
}
