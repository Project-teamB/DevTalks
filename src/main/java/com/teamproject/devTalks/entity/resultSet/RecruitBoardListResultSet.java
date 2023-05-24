package com.teamproject.devTalks.entity.resultSet;

public interface RecruitBoardListResultSet {
    public int getRecruitBoardNumber();
    public String getRecruitBoardTitle();
    public String getWriteDatetime();
    public String getWriterEmail();
    public String getWriterNickname();
    public String getWriterProfileImageUrl();
    public int getViewCount();
    public int getCommentCount();
    public int getHeartCount();
    public boolean isRecruitmentStatus();
}
