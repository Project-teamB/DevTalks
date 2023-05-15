package com.teamproject.devTalks.repository.board;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teamproject.devTalks.entity.board.TeacherBoardEntity;
import com.teamproject.devTalks.entity.resultSet.TeacherBoardListResultSet;

@Repository
public interface TeacherBoardRepository extends JpaRepository<TeacherBoardEntity,Integer> {
    public TeacherBoardEntity findByTeacherBoardNumber(int boardNumber);
    public TeacherBoardEntity findByWriterEmail(String email);
    List<TeacherBoardListResultSet> findAllByOrderByWriteDatetimeDesc();

    @Transactional
    void deleteByBoardNumber(int teacherBoardNumber);
}
