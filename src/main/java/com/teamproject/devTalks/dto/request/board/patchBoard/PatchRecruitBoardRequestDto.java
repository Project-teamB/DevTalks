package com.teamproject.devTalks.dto.request.board.patchBoard;

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
    private String recruitImageUrl;
    private boolean recruitmentStatus;

}
