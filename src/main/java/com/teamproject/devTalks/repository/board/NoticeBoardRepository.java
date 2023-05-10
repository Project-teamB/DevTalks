package com.teamproject.devTalks.repository.board;

import com.teamproject.devTalks.entity.board.NoticeBoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeBoardRepository extends JpaRepository<NoticeBoardEntity,Integer> {

    public NoticeBoardEntity findByNoticeBoardNumber(int boardNumber);
    public NoticeBoardEntity findByWriterEmail(String email);
}
