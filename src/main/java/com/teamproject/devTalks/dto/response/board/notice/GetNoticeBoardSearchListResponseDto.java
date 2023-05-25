package com.teamproject.devTalks.dto.response.board.notice;

import java.util.ArrayList;
import java.util.List;

import com.teamproject.devTalks.dto.response.ResponseDto;
import com.teamproject.devTalks.entity.resultSet.NoticeBoardListResultSet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class GetNoticeBoardSearchListResponseDto extends ResponseDto {
    private List<NoticeBoardSummary> noticeSearchBoardList;
    
    public GetNoticeBoardSearchListResponseDto(List<NoticeBoardListResultSet> resultSet) {
        super("SU", "SUCCESS");

        List<NoticeBoardSummary> noticeSearchBoardList = new ArrayList<>();

        for(NoticeBoardListResultSet result: resultSet) {
            NoticeBoardSummary noticeBoardSummary = new NoticeBoardSummary(result);
            noticeSearchBoardList.add(noticeBoardSummary);
        }

        this.noticeSearchBoardList = noticeSearchBoardList;
    }
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class NoticeBoardSummary {
    public int noticeBoardNumber;
    public String noticeTitle;
    public String writeDatetime;
    public int viewCount;
    public String writerNickname;
    public String writerEmail;
    public String writerProfileImageUrl;

    public NoticeBoardSummary(NoticeBoardListResultSet resultSet) {
        this.noticeBoardNumber = resultSet.getNoticeBoardNumber();
        this.noticeTitle = resultSet.getNoticeTitle();
        this.writeDatetime = resultSet.getWriteDatetime();
        this.viewCount = resultSet.getViewCount();
        this.writerNickname = resultSet.getWriterNickname();
        this.writerEmail = resultSet.getWriterEmail();
        this.writerProfileImageUrl = resultSet.getWriterProfileImageUrl();
    }
}

