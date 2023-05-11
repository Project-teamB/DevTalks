package com.teamproject.devTalks.entity.resultSet;

public interface RecruitBoardListResultSet {
    public int getRecruitBoardNumber();
    public String getRecruitTitle();
    public String getRecruitContent();
    public String getRecruitBoardImageUrl();
    public String GetWriteDatetime();
    public String GetUpdateDatetime();
    public String GetWriterEmail();
    public String GetWriterNickname();
    public String GetWriterProfileImageUrl();
    public int GetCommentCount();
    public int GetHeartCount();
    public String GetHashTag();
}
