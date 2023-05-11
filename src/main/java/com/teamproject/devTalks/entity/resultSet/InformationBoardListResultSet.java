package com.teamproject.devTalks.entity.resultSet;

public interface InformationBoardListResultSet {
    public int getInformationBoardNumber();
    public String getWriterProfileImageUrl();
    public String getWriterNickname();
    public String getWriterEmail();
    public String getInformationBoardTitle();
    public String getInformationBoardContent();
    public String getInformationBoardImageUrl();
    public String getContentSource();
    public int getViewCount();
    public String getWriteDatetime();
    public String getUpdateDatetime();
    public int getCommentCount();
    public int getHeartCount();
    public String getInformationBoardHashtag();
}
