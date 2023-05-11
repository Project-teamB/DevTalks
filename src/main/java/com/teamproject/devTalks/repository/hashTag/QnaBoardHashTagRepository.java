package com.teamproject.devTalks.repository.hashTag;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teamproject.devTalks.entity.hashTag.QnaBoardHashTagEntity;
import com.teamproject.devTalks.entity.primaryKey.qna.QnaHashTagPk;

@Repository
public interface QnaBoardHashTagRepository extends JpaRepository<QnaBoardHashTagEntity, QnaHashTagPk>{

}
