package com.teamproject.devTalks.repository.board;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.teamproject.devTalks.entity.board.RecruitBoardEntity;
import com.teamproject.devTalks.entity.resultSet.RecruitBoardListResultSet;

@Repository
public interface RecruitBoardRepository extends JpaRepository<RecruitBoardEntity, Integer> {

    public RecruitBoardEntity findByRecruitBoardNumber(Integer recruitBoardNumber);

    @Query(value = "SELECT " +
    "* " + 
    "FROM devtalks.recruit_board_list_view " +
    "ORDER BY writeDatetime DESC ", nativeQuery = true
    )
    
    public List<RecruitBoardListResultSet> getRecruitBoardListOrderByWriteDateTime();
    
    @Query(value = "SELECT " +
    "* " + 
    "FROM devtalks.recruit_board_list_view " +
    "ORDER BY recruitHeartCount DESC ", nativeQuery = true
    )
    public List<RecruitBoardListResultSet> getRecruitBoardListOrderByHeartCount();

    @Query(value = "SELECT " +
    "* " + 
    "FROM devtalks.recruit_board_list_view " +
    "ORDER BY recruitCommentCount DESC ", nativeQuery = true
    )
    public List<RecruitBoardListResultSet> getRecruitBoardListOrderByCommentCount();

    @Query(value = "SELECT " +
    "* " + 
    "FROM devtalks.recruit_board_list_view " +
    "ORDER BY viewCount DESC ", nativeQuery = true
    )
    public List<RecruitBoardListResultSet> getRecruitBoardListOrderByViewCount();


    // @Query(value = "SELECT " +
    // "R.recruit_board_number AS recruitBoardNumber, " +
    // "R.recruit_board_title AS recruitBoardTitle, " +
    // "R.writer_profile_image_url AS writerProfileImageUrl, " +
    // "R.writer_nickname AS writerNickname, " +
    // "R.writer_email AS writerEmail, " +
    // "R.write_datetime AS writeDatetime, " +
    // "R.view_count AS viewCount, " +
    // "count(C.recruit_comment_number) AS commentCount, " +
    // "count(H.user_number) AS heartCount, " +
    // "R.recruitment_status AS recruitmentStatus " +
    // "FROM recruit R " +
    // "LEFT JOIN recruit_comment C " +
    // "ON R.recruit_board_number = C.recruit_board_number " +
    // "LEFT JOIN recruit_heart H " +
    // "ON R.recruit_board_number = H.recruit_board_number " +
    // "WHERE R.recruit_board_title LIKE ? " +
    // "GROUP BY recruitBoardNumber " +
    // "ORDER BY writeDatetime DESC ", nativeQuery = true
    // )

    @Query(value = "SELECT " +
    "* " + 
    "FROM recruit_board_search_list_view " +
    "WHERE recruitBoardTitle LIKE ? " +
    "ORDER BY writeDatetime DESC ", nativeQuery = true
    )

    public List<RecruitBoardListResultSet> findByRecruitBoardTitleContaining(String searchKeyword);

    @Query(value = "SELECT " +
    "* " + 
    "FROM recruit_board_search_list_view " +
    "WHERE writerNickname LIKE ? " +
    "ORDER BY writeDatetime DESC ", nativeQuery = true
    )
    public List<RecruitBoardListResultSet> findByWriterNicknameContaining(String searchKeyword);

    @Transactional
    public void deleteByRecruitBoardNumber(int recruitBoardNumber);

}
