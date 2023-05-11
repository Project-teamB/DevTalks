package com.teamproject.devTalks.dto.request.comment.qna;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostQnaCommentRequestDto {
    
    @NotBlank
    private int qnaBoardNumber;
    @NotBlank
    private String commentContent;

}
