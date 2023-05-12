package com.teamproject.devTalks.repository.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.teamproject.devTalks.entity.comment.RecruitCommentEntity;

@Repository
public interface RecruitCommentRepository extends JpaRepository<RecruitCommentEntity, Integer>{
    public RecruitCommentEntity findByRecruitCommentNumber(int recruitBoardNumber);

    @Transactional
    void deleteByRecruitBoardNumber(int recruitBoardNumber);
}
