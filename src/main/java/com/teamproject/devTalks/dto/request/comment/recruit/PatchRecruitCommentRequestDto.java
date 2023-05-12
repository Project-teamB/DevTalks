package com.teamproject.devTalks.dto.request.comment.recruit;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PatchRecruitCommentRequestDto {
    
    @NotBlank
    private int recruitCommentNumber;
    @NotBlank
    private String recruitCommentContent;

    public PatchRecruitCommentRequestDto(PatchRecruitCommentRequestDto dto) {
        this.recruitCommentNumber = dto.getRecruitCommentNumber();
        this.recruitCommentContent = dto.getRecruitCommentContent();
    }

}
