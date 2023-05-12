package com.teamproject.devTalks.dto.response.board.teacher;

import java.util.ArrayList;
import java.util.List;

import com.teamproject.devTalks.dto.response.ResponseDto;
import com.teamproject.devTalks.entity.resultSet.TeacherBoardListResultSet;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class GetTeacherBoardListResponseDto extends ResponseDto{
    private List<TeacherBoardSummary> teacherBoardList;
    public GetTeacherBoardListResponseDto(List<TeacherBoardListResultSet> resultSet) {
        super("SU", "SUCCESS");

        List<TeacherBoardSummary> recruitBoardList = new ArrayList<>();

        for (TeacherBoardListResultSet result: resultSet) {
            TeacherBoardSummary recruitBoardSummary = new TeacherBoardSummary(result);
            recruitBoardList.add(recruitBoardSummary);
        }
        this.teacherBoardList = recruitBoardList;
    }
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class TeacherBoardSummary {
    private int teacherBoardNumber;
    private String teacherTitle;
    private String teacherContent;
    private String teacherBoardImageUrl;
    private String writeDatetime;
    private String updateDatetime;
    private String writerEmail;
    private String writerNickname;
    private String writerProfileImageUrl;
    private int heartCount;
    private String hashTag;

    public TeacherBoardSummary(TeacherBoardListResultSet resultSet){
        this.teacherBoardNumber = resultSet.getteacherBoardNumber();
        this.teacherTitle = resultSet.getteacherTitle();
        this.teacherContent = resultSet.getteacherContent();
        this.teacherBoardImageUrl = resultSet.getteacherBoardImageUrl();
        this.writeDatetime = resultSet.getwriteDatetime();
        this.updateDatetime = resultSet.getupdateDatetime();
        this.writerEmail = resultSet.getwriterEmail();
        this.writerNickname = resultSet.getwriterNickname();
        this.writerProfileImageUrl = resultSet.getwriterProfileImageUrl();
        this.heartCount = resultSet.getheartCount();
        this.hashTag = resultSet.gethashTag();
    }
}