package com.teamproject.devTalks.dto.request.board.recruit;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostRecruitBoardRequestDto {
    
    @Email
    @NotBlank
    private String writerEmail;
    @NotBlank
    private String recruitTitle;
    @NotBlank
    private String recruitContent;
    private String recruitImageUrl;
    @NotBlank 
    private String hashtag;
    private boolean recruitmentStatus;
    
}
