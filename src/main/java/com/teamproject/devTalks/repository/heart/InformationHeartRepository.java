package com.teamproject.devTalks.repository.heart;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.teamproject.devTalks.entity.heart.InformationHeartEntity;
import com.teamproject.devTalks.entity.primaryKey.information.InformationHeartPk;

@Repository
public interface InformationHeartRepository  extends JpaRepository<InformationHeartEntity, InformationHeartPk> {


    List<InformationHeartEntity> findByInformationBoardNumber(int informationBoardNumber);

    @Transactional
    void deleteByInformationBoardNumber(int informationBoardNumber);

    @Transactional
    void deleteByUserNumberAndInformationBoardNumber(int userNumber, int informationBoardNumber);

    // 추가 기능: 사용자의 좋아요 여부 확인
    boolean existsByUserNumberAndInformationBoardNumber(int userNumber, int informationBoardNumber);

    // 추가 기능: 좋아요 개수 조회
    long countByInformationBoardNumber(int informationBoardNumber);

}
