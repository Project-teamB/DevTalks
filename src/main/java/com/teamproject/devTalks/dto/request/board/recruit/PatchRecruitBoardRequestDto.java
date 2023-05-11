package com.teamproject.devTalks.dto.request.board.recruit;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class PatchRecruitBoardRequestDto {
    
    @NotBlank
    @Email
    private String writerEmail;
    @NotBlank
    private int recruitBoardNumber;
    @NotBlank
    private String recruitTitle;
    @NotBlank
    private String recruitContent;
    private String recruitBoardImageUrl;
    private boolean recruitmentStatus;

    public PatchRecruitBoardRequestDto(PatchRecruitBoardRequestDto dto) {
        this.writerEmail = dto.getWriterEmail();
        this.recruitBoardNumber = dto.getRecruitBoardNumber();
        this.recruitTitle = dto.getRecruitTitle();
        this.recruitContent = dto.getRecruitContent();
        this.recruitBoardImageUrl = dto.getRecruitBoardImageUrl();
    }

}
