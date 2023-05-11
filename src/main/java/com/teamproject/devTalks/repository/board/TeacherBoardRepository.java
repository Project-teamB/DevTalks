package com.teamproject.devTalks.repository.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teamproject.devTalks.entity.board.TeacherBoardEntity;

@Repository
public interface TeacherBoardRepository extends JpaRepository<TeacherBoardEntity,Integer> {
    public TeacherBoardEntity findByTeacherBoardNumber(int boardNumber);
    public TeacherBoardEntity findByWriterEmail(String email);
}
