package com.teamproject.devTalks.dto.request.board.qna;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PatchQnaBoardRequestDto {
    
    @NotBlank
    private int qnaboardNumber;
    @NotBlank
    private String qnaTitle;
    @NotBlank
    private String qnaContent;
    private String qnaBoardImageUrl;


}
