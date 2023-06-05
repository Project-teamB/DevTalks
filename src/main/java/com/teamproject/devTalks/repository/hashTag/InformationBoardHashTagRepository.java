package com.teamproject.devTalks.repository.hashTag;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teamproject.devTalks.entity.hashTag.InformationBoardHashTagEntity;
import com.teamproject.devTalks.entity.primaryKey.information.InformationHashtagPk;

@Repository
public interface InformationBoardHashTagRepository extends JpaRepository<InformationBoardHashTagEntity, InformationHashtagPk> {

    public List<InformationBoardHashTagEntity> findByInformationBoardNumber(Integer informationBoardNumber);
    
    @Transactional
    void deleteByInformationBoardNumber(Integer informationBoardNumber);

    @Transactional
    void deleteByBoardHashtagAndInformationBoardNumber(String boardHashtag, Integer informationBoardNumber);
}
