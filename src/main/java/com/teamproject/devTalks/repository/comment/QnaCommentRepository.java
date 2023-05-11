package com.teamproject.devTalks.repository.comment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.teamproject.devTalks.entity.comment.QnaCommentEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface QnaCommentRepository extends JpaRepository<QnaCommentEntity, Integer>{
    
    List<QnaCommentEntity> findByQnaBoardNumber (int qnaBoardNumber);
    

}
