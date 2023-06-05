package com.teamproject.devTalks.repository.comment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.teamproject.devTalks.entity.comment.InformationCommentEntity;

public interface InformationCommentRepository extends JpaRepository<InformationCommentEntity, Integer> {

    List<InformationCommentEntity> findByInformationBoardNumber(Integer informationBoardNumber);

    public InformationCommentEntity findByInformationCommentNumber(Integer informationCommentNumber);

    @Transactional
    void deleteByInformationBoardNumber(Integer informationBoardNumber);

    @Transactional
    void deleteByInformationCommentNumber(Integer informationCommentNumber);


}
