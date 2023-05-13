package com.teamproject.devTalks.repository.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teamproject.devTalks.entity.board.InformationBoardEntity;

@Repository
public interface InformationBoardRepository extends JpaRepository<InformationBoardEntity, Integer> {
    
    public InformationBoardEntity findByInformationBoardNumber(int informationBoardNumber);

}
