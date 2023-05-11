package com.teamproject.devTalks.dto.request.comment.patchComment;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PatchQnaCommentRequestDto {
    
    @NotBlank
    private int qnaCommentNumber;
    @NotBlank
    private String commentContent;



}
