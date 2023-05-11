package com.teamproject.devTalks.dto.response.board.qna;

import java.util.List;

import com.teamproject.devTalks.dto.response.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetQnaBoardListResponseDto extends ResponseDto {
    
    private List<BoardSummary> boardList;

}

@Data
@NoArgsConstructor
@AllArgsConstructor
class BoardSummary {
    private int quaBoardNumber;
	private String qnaTitle; 
	private String qnaContent; 
	private String qnaBoardImageUrl; 
	private String writeDatetime; 
	private int viewCount; 
    private String writerNickname;
	private String writerProfileImageUrl;
	private int commentCount;
	private int heartCount;
	private List<String> hashtag;
}
