package com.teamproject.devTalks.dto.request.board.postBoard;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostInformationBoardRequestDto {
    @NotBlank
    private String informationBoardTitle;
    @NotBlank
    private String informationBoardContent;
    private String informationBoardImageUrl;
    @NotBlank
    private String contentSource;

    public PostInformationBoardRequestDto(PostInformationBoardRequestDto dto) {
        this.informationBoardTitle = dto.getInformationBoardTitle();
        this.informationBoardContent = dto.getInformationBoardContent();
        this.informationBoardImageUrl = dto.getInformationBoardImageUrl();
        this.contentSource = dto.getContentSource();
    }
}
