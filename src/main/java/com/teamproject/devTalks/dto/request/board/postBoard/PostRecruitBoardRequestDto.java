package com.teamproject.devTalks.dto.request.board.postBoard;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostRecruitBoardRequestDto {
    
    @NotBlank
    @Email
    private String writerEmail;
    @NotBlank
    private String recruitTitle;
    @NotBlank
    private String recruitContent;
    private String recruitImageUrl;
    @NotBlank 
    private String hashtag;
    private boolean recruitmentStatus;

    public PostRecruitBoardRequestDto(PostRecruitBoardRequestDto dto) {
        this.writerEmail = dto.getWriterEmail();
        this.recruitTitle = dto.getRecruitTitle();
        this.recruitContent = dto.getRecruitContent();
        this.recruitImageUrl = dto.getRecruitImageUrl();
        this.hashtag = dto.getHashtag();
    }
}
