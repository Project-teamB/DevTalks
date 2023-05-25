package com.teamproject.devTalks.repository.board;

import com.teamproject.devTalks.entity.board.NoticeBoardEntity;
import com.teamproject.devTalks.entity.resultSet.NoticeBoardListResultSet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeBoardRepository extends JpaRepository<NoticeBoardEntity,Integer> {

    public NoticeBoardEntity findByNoticeBoardNumber(int boardNumber);

    List<NoticeBoardEntity> findAllByOrderByWriteDatetimeDesc();

    // @Query(value = "SELECT  " +
    // "N.notice_board_number AS noticeBoardNumber, " +
    // "N.notice_title AS noticeTitle, " +
    // "N.write_datetime AS writeDatetime, " +
    // "N.view_count AS viewCount, " +
    // "N.writer_nickname AS writerNickname, " +
    // "N.writer_email AS writerEmail, " +
    // "N.writer_profile_image_url AS writerProfileImageUrl " +
    // "FROM notice N " +
    // "ORDER BY writeDatetime ", nativeQuery = true
    // )
    public List<NoticeBoardEntity> findByNoticeTitleContaining(String searchKeyword);
    
}
