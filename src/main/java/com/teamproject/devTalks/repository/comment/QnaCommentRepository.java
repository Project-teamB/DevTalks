package com.teamproject.devTalks.repository.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teamproject.devTalks.entity.comment.QnaCommentEntity;

@Repository
public interface QnaCommentRepository extends JpaRepository<QnaCommentEntity, Integer> {

    public QnaCommentEntity findByQnaCommentNumber(int qnaCommentNumber);

}
