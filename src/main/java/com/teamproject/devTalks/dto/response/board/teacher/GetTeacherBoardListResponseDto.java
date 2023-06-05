package com.teamproject.devTalks.dto.response.board.teacher;

import java.util.ArrayList;
import java.util.List;
import com.teamproject.devTalks.dto.response.ResponseDto;
import com.teamproject.devTalks.entity.view.GetTeacherListViewEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class GetTeacherBoardListResponseDto extends ResponseDto {

    private List<TeacherBoardSummary> teacherBoardList;

    public GetTeacherBoardListResponseDto(List<GetTeacherListViewEntity> teacherBoardEntityList) {
        super("SU", "SUCCESS");

        List<TeacherBoardSummary> teacherBoardList = new ArrayList<>();

        for (GetTeacherListViewEntity result : teacherBoardEntityList) {
            TeacherBoardSummary teacherBoardSummary = new TeacherBoardSummary(result);
            teacherBoardList.add(teacherBoardSummary);
        }

        this.teacherBoardList = teacherBoardList;
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
    private String writeDatetime;
    private int viewCount;
    private String writerEmail;
    private String writerNickname;
    private String writerProfileImageUrl;
    private String teacherBoardImageUrl;
    private int heartCount;

    public TeacherBoardSummary(GetTeacherListViewEntity entity) {
        this.teacherBoardNumber = entity.getTeacherBoardNumber();
        this.teacherTitle = entity.getTeacherBoardTitle();
        this.teacherContent = entity.getTeacherBoardContent();
        this.writeDatetime = entity.getWriteDatetime();
        this.teacherBoardImageUrl = entity.getTeacherBoardImageUrl();
        this.writerEmail = entity.getWriterEmail();
        this.writerNickname = entity.getWriterNickname();
        this.writerProfileImageUrl = entity.getWriterProfileImageUrl();
        this.viewCount = entity.getViewCount();
        this.heartCount = entity.getHeartCount();
    }
}