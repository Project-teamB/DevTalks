package com.teamproject.devTalks.entity.resultSet;

public interface RecruitBoardListResultSet {
    public int getRecruitBoardNumber();
    public String getRecruitBoardTitle();
    public String getRecruitBoardContent();
    public String getRecruitBoardImageUrl();
    public String getWriteDatetime();
    public String getUpdateDatetime();
    public String getWriterEmail();
    public String getWriterNickname();
    public String getWriterProfileImageUrl();
    public int getCommentCount();
    public int getHeartCount();
    public String getHashTag();
    public boolean isRecruitmentStatus();
}
