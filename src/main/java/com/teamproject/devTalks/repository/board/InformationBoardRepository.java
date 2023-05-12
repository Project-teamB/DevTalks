package com.teamproject.devTalks.repository.board;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teamproject.devTalks.entity.board.InformationBoardEntity;

public interface InformationBoardRepository extends JpaRepository<InformationBoardEntity, Integer> {
    
    public InformationBoardEntity findByInformationBoardNumber(int informationBoardNumber);

}
