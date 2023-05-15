package com.teamproject.devTalks.dto.response.board.qna;

import java.util.List;

import com.mysql.cj.protocol.Resultset;
import com.teamproject.devTalks.dto.response.ResponseDto;
import com.teamproject.devTalks.entity.board.QnaBoardEntity;
import com.teamproject.devTalks.entity.resultSet.QnaBoardListResultSet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetQnaBoardListResponseDto extends ResponseDto {
    
    private List<BoardSummary> qnaBoardList;
	


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

	public BoardSummary(QnaBoardListResultSet resultSets){
		this.quaBoardNumber = resultSets.getQnaBoardNumber();
		this.qnaTitle = resultSets.getQnaTitle(); 
		this.qnaContent = resultSets.getQnaContent(); 
		this.qnaBoardImageUrl = resultSets.getQnaBoardImageUrl(); 
		this.writeDatetime = resultSets.getWriteDatetime();
		this.viewCount = resultSets.getViewCount();
		this.writerNickname = resultSets.getWriterNickname();
		this.writerProfileImageUrl = resultSets.getWriterProfileImageUrl();
		this.commentCount = resultSets.getCommentCount();
		this.heartCount = resultSets.getHeartCount();
		// this.hashtag = resultSets.getHashtag();
	}
}







