package com.teamproject.devTalks.repository.board;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.teamproject.devTalks.entity.board.TeacherBoardEntity;
import com.teamproject.devTalks.entity.resultSet.TeacherBoardListResultSet;

@Repository
public interface TeacherBoardRepository extends JpaRepository<TeacherBoardEntity,Integer> {
    public TeacherBoardEntity findByTeacherBoardNumber(int boardNumber);
    public TeacherBoardEntity findByWriterEmail(String email);
    

    // @Transactional
    // void deleteByteacherBoardNumber(int teacherBoardNumber);

    // @Query
    // (value = "SELECT " +
    //         "Q.teacher_board_number AS teacherBoardNumber, " +
    //         "Q.teacher_title AS teacherTitle, " +
    //         "Q.teacher_content AS teacherContent, " +
    //         "Q.teacher_board_image_url AS teacherBoardImageUrl, " +
    //         "Q.write_datetime AS writeDatetime, " +
    //         "Q.view_count AS viewCount, " +
    //         "Q.writer_email AS writerEmail, " +
    //         "Q.writer_nickname AS writerNickname, " +
    //         "Q.writer_profile_image_url AS writerProfileImageUrl, " +
    //         "count(C.comment_number) AS teacherCommentCount, " +
    //         "count(H.user_number) AS teacherHeartCount " +
    //         "FROM teacher Q, teacher_comment C, teacher_heart H, teacher_hashtag T " +
    //         "WHERE Q.teacher_board_number = C.teacher_board_number " +
    //         "AND Q.teacher_board_number = H.teacher_board_number " +
    //         "group by teacherBoardNumber " +
    //         "order by writeDatetime ", nativeQuery = true)

    // public List<TeacherBoardListResultSet> getList();
}
