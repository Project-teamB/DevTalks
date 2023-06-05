package com.teamproject.devTalks.repository.board;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.teamproject.devTalks.entity.board.TeacherBoardEntity;
import com.teamproject.devTalks.entity.resultSet.TeacherBoardListResultSet;

@Repository
public interface TeacherBoardRepository extends JpaRepository<TeacherBoardEntity, Integer> {
        public TeacherBoardEntity findByTeacherBoardNumber(int boardNumber);


        @Query(value = "SELECT " +
                "T.teacher_board_number AS teacherBoardNumber, " +
                "T.teacher_title AS teacherTitle, " +
                "T.write_datetime AS writeDatetime, " +
                "T.view_count AS viewCount, " +
                "T.writer_email AS writerEmail, " +
                "T.writer_nickname AS writerNickname, " +
                "T.writer_profile_image_url AS writerProfileImageUrl, " +
                "count(H.user_number) AS teacherHeartCount " +
                "FROM teacher T " +
                "LEFT JOIN teacher_heart H " +
                "ON T.teacher_board_number = H.teacher_board_number " +
                "GROUP BY teacherBoardNumber " +
                "ORDER BY writeDatetime DESC ", nativeQuery = true)
        public List<TeacherBoardListResultSet> getListOrderByWriteDatetime();

        @Query(value = "SELECT " +
                "T.teacher_board_number AS teacherBoardNumber, " +
                "T.teacher_title AS teacherTitle, " +
                "T.write_datetime AS writeDatetime, " +
                "T.view_count AS viewCount, " +
                "T.writer_email AS writerEmail, " +
                "T.writer_nickname AS writerNickname, " +
                "T.writer_profile_image_url AS writerProfileImageUrl, " +
                "count(H.user_number) AS teacherHeartCount " +
                "FROM teacher T " +
                "LEFT JOIN teacher_heart H " +
                "ON T.teacher_board_number = H.teacher_board_number " +
                "group by teacherBoardNumber " +
                "order by teacherHeartCount DESC ", nativeQuery = true)
        public List<TeacherBoardListResultSet> getListOrderByHeartCount();

        @Query(value = "SELECT " +
                "T.teacher_board_number AS teacherBoardNumber, " +
                "T.teacher_title AS teacherTitle, " +
                "T.write_datetime AS writeDatetime, " +
                "T.view_count AS viewCount, " +
                "T.writer_email AS writerEmail, " +
                "T.writer_nickname AS writerNickname, " +
                "T.writer_profile_image_url AS writerProfileImageUrl, " +
                "count(H.user_number) AS teacherHeartCount " +
                "FROM teacher T " +
                "LEFT JOIN teacher_heart H " +
                "ON T.teacher_board_number = H.teacher_board_number " +
                "GROUP BY teacherBoardNumber " +
                "order by viewCount DESC ", nativeQuery = true)
        public List<TeacherBoardListResultSet> getListOrderByViewCount();


        @Query(value = "SELECT " +
                        "T.teacher_board_number AS teacherBoardNumber, " +
                        "T.teacher_title AS teacherTitle, " +
                        "T.write_datetime AS writeDatetime, " +
                        "T.view_count AS viewCount, " +
                        "T.writer_email AS writerEmail, " +
                        "T.writer_nickname AS writerNickname, " +
                        "T.writer_profile_image_url AS writerProfileImageUrl, " +
                        "count(H.user_number) AS teacherHeartCount " +
                        "FROM teacher T " +
                        "LEFT JOIN teacher_heart H " +
                        "ON T.teacher_board_number = H.teacher_board_number " +
                        "WHERE T.teacher_title LIKE ? " +
                        "GROUP BY teacherBoardNumber " +
                        "order by writeDatetime DESC ", nativeQuery = true)
        public List<TeacherBoardListResultSet> findByTeacherBoardTitleContaining(String searchKeyword);

        @Query(value = "SELECT " +
                        "T.teacher_board_number AS teacherBoardNumber, " +
                        "T.teacher_title AS teacherTitle, " +
                        "T.write_datetime AS writeDatetime, " +
                        "T.view_count AS viewCount, " +
                        "T.writer_email AS writerEmail, " +
                        "T.writer_nickname AS writerNickname, " +
                        "T.writer_profile_image_url AS writerProfileImageUrl, " +
                        "count(H.user_number) AS teacherHeartCount " +
                        "FROM teacher T " +
                        "LEFT JOIN teacher_heart H " +
                        "ON T.teacher_board_number = H.teacher_board_number " +
                        "WHERE T.writer_nickname LIKE ? " +
                        "GROUP BY teacherBoardNumber " +
                        "order by writeDatetime DESC ", nativeQuery = true)
        public List<TeacherBoardListResultSet> findByWriterNicknameContaining(String searchKeyword);

}