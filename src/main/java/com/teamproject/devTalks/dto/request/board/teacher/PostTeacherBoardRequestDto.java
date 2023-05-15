package com.teamproject.devTalks.dto.request.board.teacher;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostTeacherBoardRequestDto {
    @NotBlank
    @Email
    private String writerEmail;
    @NotBlank
    private String teacherTitle;
    @NotBlank
    private String teacherContent;
    private String teacherBoardImageUrl;
    private String career;
    private String lectureUrl;
    private String category;
    private String teacherBoardHashtag;

    public PostTeacherBoardRequestDto(PostTeacherBoardRequestDto dto){
        this.writerEmail = dto.getWriterEmail();
        this.teacherTitle = dto.getTeacherTitle();
        this.teacherContent = dto.getTeacherContent();
        this.teacherBoardImageUrl = dto.getTeacherBoardImageUrl();
        this.career = dto.getCareer();
        this.lectureUrl = dto.getLectureUrl();
        this.category = dto.getCategory();
        this.teacherBoardHashtag = dto.getTeacherBoardHashtag();
    }
}
