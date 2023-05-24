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
public interface TeacherBoardRepository extends JpaRepository<TeacherBoardEntity,Integer> {
        public TeacherBoardEntity findByTeacherBoardNumber(int boardNumber);
        public TeacherBoardEntity findByWriterEmail(String email);
        List<TeacherBoardListResultSet> findAllByOrderByWriteDatetimeDesc();

        @Transactional
        void deleteByteacherBoardNumber(int teacherBoardNumber);

        //모집 완료
        @Query
        (value = "SELECT " +
                "T.teacher_board_number AS teacherBoardNumber, " +
                "T.teacher_title AS teacherTitle, " +
                "T.teacher_content AS teacherContent, " +
                "T.teacher_board_image_url AS teacherBoardImageUrl, " +
                "T.write_datetime AS writeDatetime, " +
                "T.view_count AS viewCount, " +
                "T.writer_email AS writerEmail, " +
                "T.writer_nickname AS writerNickname, " +
                "T.writer_profile_image_url AS writerProfileImageUrl, " +
                "count(C.comment_number) AS teacherCommentCount, " +
                "count(H.user_number) AS teacherHeartCount " +
                "FROM teacher T " +
                "LEFT JOIN teacher_heart H " +
                "ON T.teacher_board_number = H.teacher_board_number " +
                "WHERE T.recruitment_status = :status " +
                "group by teacherBoardNumber " +
                "order by writeDatetime DESC ", nativeQuery = true)
        public List<TeacherBoardListResultSet> getListOrderByWriteDatetimeCompleted(@Param("status") boolean status);

        @Query
        (value = "SELECT " +
                "T.teacher_board_number AS teacherBoardNumber, " +
                "T.teacher_title AS teacherTitle, " +
                "T.teacher_content AS teacherContent, " +
                "T.teacher_board_image_url AS teacherBoardImageUrl, " +
                "T.write_datetime AS writeDatetime, " +
                "T.view_count AS viewCount, " +
                "T.writer_email AS writerEmail, " +
                "T.writer_nickname AS writerNickname, " +
                "T.writer_profile_image_url AS writerProfileImageUrl, " +
                "count(C.comment_number) AS teacherCommentCount, " +
                "count(H.user_number) AS teacherHeartCount " +
                "FROM teacher T " +
                "LEFT JOIN teacher_heart H " +
                "ON T.teacher_board_number = H.teacher_board_number " +
                "WHERE T.recruitment_status = :status " +
                "group by teacherBoardNumber " +
                "order by teacherHeartCount DESC ", nativeQuery = true)
        public List<TeacherBoardListResultSet> getListOrderByHeartCountCompleted(@Param("status") boolean status);

        @Query
        (value = "SELECT " +
                "T.teacher_board_number AS teacherBoardNumber, " +
                "T.teacher_title AS teacherTitle, " +
                "T.teacher_content AS teacherContent, " +
                "T.teacher_board_image_url AS teacherBoardImageUrl, " +
                "T.write_datetime AS writeDatetime, " +
                "T.view_count AS viewCount, " +
                "T.writer_email AS writerEmail, " +
                "T.writer_nickname AS writerNickname, " +
                "T.writer_profile_image_url AS writerProfileImageUrl, " +
                "count(C.comment_number) AS teacherCommentCount, " +
                "count(H.user_number) AS teacherHeartCount " +
                "FROM teacher T " +
                "LEFT JOIN teacher_heart H " +
                "ON T.teacher_board_number = H.teacher_board_number " +
                "WHERE T.recruitment_status = :status " +
                "group by teacherBoardNumber " +
                "order by viewCount DESC ", nativeQuery = true)
        public List<TeacherBoardListResultSet> getListOrderByViewCountCompleted(@Param("status") boolean status);

        //모집중
        @Query
        (value = "SELECT " +
                "T.teacher_board_number AS teacherBoardNumber, " +
                "T.teacher_title AS teacherTitle, " +
                "T.teacher_content AS teacherContent, " +
                "T.teacher_board_image_url AS teacherBoardImageUrl, " +
                "T.write_datetime AS writeDatetime, " +
                "T.view_count AS viewCount, " +
                "T.writer_email AS writerEmail, " +
                "T.writer_nickname AS writerNickname, " +
                "T.writer_profile_image_url AS writerProfileImageUrl, " +
                "count(C.comment_number) AS teacherCommentCount, " +
                "count(H.user_number) AS teacherHeartCount " +
                "FROM teacher T " +
                "LEFT JOIN teacher_heart H " +
                "ON T.teacher_board_number = H.teacher_board_number " +
                "WHERE T.recruitment_status = :status " +
                "group by teacherBoardNumber " +
                "order by writeDatetime DESC ", nativeQuery = true)
        public List<TeacherBoardListResultSet> getListOrderByWriteDatetimeProgress(@Param("status") boolean status);

        @Query
        (value = "SELECT " +
                "T.teacher_board_number AS teacherBoardNumber, " +
                "T.teacher_title AS teacherTitle, " +
                "T.teacher_content AS teacherContent, " +
                "T.teacher_board_image_url AS teacherBoardImageUrl, " +
                "T.write_datetime AS writeDatetime, " +
                "T.view_count AS viewCount, " +
                "T.writer_email AS writerEmail, " +
                "T.writer_nickname AS writerNickname, " +
                "T.writer_profile_image_url AS writerProfileImageUrl, " +
                "count(C.comment_number) AS teacherCommentCount, " +
                "count(H.user_number) AS teacherHeartCount " +
                "FROM teacher T " +
                "LEFT JOIN teacher_heart H " +
                "ON T.teacher_board_number = H.teacher_board_number " +
                "WHERE T.recruitment_status = :status " +
                "group by teacherBoardNumber " +
                "order by teacherHeartCount DESC ", nativeQuery = true)
        public List<TeacherBoardListResultSet> getListOrderByHeartCountProgress(@Param("status") boolean status);

        @Query
        (value = "SELECT " +
                "T.teacher_board_number AS teacherBoardNumber, " +
                "T.teacher_title AS teacherTitle, " +
                "T.teacher_content AS teacherContent, " +
                "T.teacher_board_image_url AS teacherBoardImageUrl, " +
                "T.write_datetime AS writeDatetime, " +
                "T.view_count AS viewCount, " +
                "T.writer_email AS writerEmail, " +
                "T.writer_nickname AS writerNickname, " +
                "T.writer_profile_image_url AS writerProfileImageUrl, " +
                "count(C.comment_number) AS teacherCommentCount, " +
                "count(H.user_number) AS teacherHeartCount " +
                "FROM teacher T " +
                "LEFT JOIN teacher_heart H " +
                "ON T.teacher_board_number = H.teacher_board_number " +
                "WHERE T.recruitment_status = :status " +
                "group by teacherBoardNumber " +
                "order by viewCount DESC ", nativeQuery = true)
        public List<TeacherBoardListResultSet> getListOrderByViewCountProgress(@Param("status") boolean status);

        @Query
        (value = "SELECT " +
                "T.teacher_board_number AS teacherBoardNumber, " +
                "T.teacher_title AS teacherTitle, " +
                "T.teacher_content AS teacherContent, " +
                "T.teacher_board_image_url AS teacherBoardImageUrl, " +
                "T.write_datetime AS writeDatetime, " +
                "T.view_count AS viewCount, " +
                "T.writer_email AS writerEmail, " +
                "T.writer_nickname AS writerNickname, " +
                "T.writer_profile_image_url AS writerProfileImageUrl, " +
                "count(C.comment_number) AS teacherCommentCount, " +
                "count(H.user_number) AS teacherHeartCount " +
                "FROM teacher T " +
                "LEFT JOIN teacher_heart H " +
                "ON T.teacher_board_number = H.teacher_board_number " +
                "WHERE T.teacher_title LIKE ? " +
                "group by teacherBoardNumber " +
                "order by writeDatetime DESC ", nativeQuery = true)
        public List<TeacherBoardListResultSet> findByTeacherBoardTitleContaining(String searchKeyword);

        @Query
        (value = "SELECT " +
                "T.teacher_board_number AS teacherBoardNumber, " +
                "T.teacher_title AS teacherTitle, " +
                "T.teacher_content AS teacherContent, " +
                "T.teacher_board_image_url AS teacherBoardImageUrl, " +
                "T.write_datetime AS writeDatetime, " +
                "T.view_count AS viewCount, " +
                "T.writer_email AS writerEmail, " +
                "T.writer_nickname AS writerNickname, " +
                "T.writer_profile_image_url AS writerProfileImageUrl, " +
                "count(C.comment_number) AS teacherCommentCount, " +
                "count(H.user_number) AS teacherHeartCount " +
                "FROM teacher T " +
                "LEFT JOIN teacher_heart H " +
                "ON T.teacher_board_number = H.teacher_board_number " +
                "WHERE T.writer_nickname LIKE ? " +
                "group by teacherBoardNumber " +
                "order by writeDatetime DESC ", nativeQuery = true)
        public List<TeacherBoardListResultSet> findByWriterNicknameContaining(String searchKeyword);
}