package com.teamproject.devTalks.dto.request.board.postBoard;

import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostTeacherBoardRequestDto {
    @NotBlank
    private String teacherTitle;
    @NotBlank
    private String teacherContent;
    private String teacherBoardImageUrl;

    public PostTeacherBoardRequestDto(PostTeacherBoardRequestDto dto){

        this.teacherTitle = dto.getTeacherTitle();
        this.teacherContent = dto.getTeacherContent();
        this.teacherBoardImageUrl = dto.getTeacherBoardImageUrl();
    }
}
