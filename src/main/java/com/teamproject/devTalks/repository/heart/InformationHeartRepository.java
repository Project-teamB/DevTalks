package com.teamproject.devTalks.repository.heart;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teamproject.devTalks.entity.heart.InformationHeartEntity;
import com.teamproject.devTalks.entity.primaryKey.information.InformationHeartPk;

@Repository
public interface InformationHeartRepository  extends JpaRepository<InformationHeartEntity, InformationHeartPk> {

    List<InformationHeartEntity> findAllByInformationBoardNumber(String informationBoardNumber);

}
