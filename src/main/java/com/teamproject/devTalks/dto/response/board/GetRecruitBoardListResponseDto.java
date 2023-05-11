package com.teamproject.devTalks.dto.response.board;

import java.util.ArrayList;
import java.util.List;

import com.teamproject.devTalks.dto.response.ResponseDto;
import com.teamproject.devTalks.entity.resultSet.RecruitBoardListResultSet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class GetRecruitBoardListResponseDto extends ResponseDto {
    private List<RecruitBoardSummary> recruitBoardList;
    
    public GetRecruitBoardListResponseDto(List<RecruitBoardListResultSet> resultSet) {
        super("SU", "SUCCESS");

        List<RecruitBoardSummary> recruitBoardList = new ArrayList<>();

        for (RecruitBoardListResultSet result: resultSet) {
            RecruitBoardSummary recruitBoardSummary = new RecruitBoardSummary(result);
            recruitBoardList.add(recruitBoardSummary);
        }
        this.recruitBoardList = recruitBoardList;
    }
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class RecruitBoardSummary {
    private int recruitBoardNumber;
    private String recruitTitle;
    private String recruitContent;
    private String recruitBoardImageUrl;
    private String writeDatetime;
    private String updateDatetime;
    private String writerEmail;
    private String writerNickname;
    private String writerProfileImageUrl;
    private int commentCount;
    private int heartCount;
    private String hashTag;

    public RecruitBoardSummary(RecruitBoardListResultSet resultSet) {
        this.recruitBoardNumber = resultSet.getRecruitBoardNumber();
        this.recruitTitle = resultSet.getRecruitTitle();
        this.recruitContent = resultSet.getRecruitContent();
        this.recruitBoardImageUrl = resultSet.getRecruitBoardImageUrl();
        this.writeDatetime = resultSet.GetWriteDatetime();
        this.updateDatetime = resultSet.GetUpdateDatetime();
        this.writerEmail = resultSet.GetWriterEmail();
        this.writerNickname = resultSet.GetWriterNickname();
        this.writerProfileImageUrl = resultSet.GetWriterProfileImageUrl();
        this.commentCount = resultSet.GetCommentCount();
        this.heartCount = resultSet.GetHeartCount();
        this.hashTag = resultSet.GetHashTag();
    }
}