package com.teamproject.devTalks.repository.heart;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.teamproject.devTalks.entity.heart.InformationHeartEntity;
import com.teamproject.devTalks.entity.primaryKey.information.InformationHeartPk;

@Repository
public interface InformationHeartRepository  extends JpaRepository<InformationHeartEntity, InformationHeartPk> {

    List<InformationHeartEntity> findByInformationBoardNumber(Integer informationBoardNumber);
    @Query(value="SELECT user_number FROM information_heart WHERE information_board_number = ?", nativeQuery=true)
    List<String> findByInformationBoardNumberToUserNumber(Integer informationBoardNumber);

    @Transactional
    void deleteByInformationBoardNumber(Integer informationBoardNumber);

    @Transactional
    void deleteByUserNumberAndInformationBoardNumber(Integer userNumber, Integer informationBoardNumber);



}
