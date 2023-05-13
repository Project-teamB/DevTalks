package com.teamproject.devTalks.repository.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teamproject.devTalks.entity.board.QnaBoardEntity;

@Repository
public interface QnaBoardRepository extends JpaRepository<QnaBoardEntity, Integer> {

    public QnaBoardEntity findByQnaBoardNumber(int qnaBoardNumber);

}
