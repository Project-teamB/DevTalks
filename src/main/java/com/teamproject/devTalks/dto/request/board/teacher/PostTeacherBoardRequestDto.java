package com.teamproject.devTalks.dto.request.board.teacher;

import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostTeacherBoardRequestDto {
    @NotBlank
    private String teacherTitle;
    private String category;
    private String lectureUrl;
    @NotBlank
    private String teacherContent;
    private String teacherBoardImageUrl;
    private String career;
    private List<String> boardHashtag;

    public PostTeacherBoardRequestDto(PostTeacherBoardRequestDto dto){
        this.teacherTitle = dto.getTeacherTitle();
        this.category = dto.getCategory();
        this.lectureUrl = dto.getLectureUrl();
        this.teacherContent = dto.getTeacherContent();
        this.teacherBoardImageUrl = dto.getTeacherBoardImageUrl();
        this.career = dto.getCareer();
    }
}
