package com.teamproject.devTalks.dto.response.board.qna;

import java.util.List;

import com.teamproject.devTalks.dto.response.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetQnaBoardResponseDto extends ResponseDto{
    
    private int qnaBoardNumber;
    private String qnaTitle;
    private String qnaContent;
    private String qnaBoardImageUrl;
    private String writeDatetime;
    private int viewCount;
    private String writerNickname;
    private String writerProfileImageUrl;
    private List<Comment> commentList;
    private int heartCount;

}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Comment {

    private int qnaCommentNumber;
    private int qnaBoardNumber;
    private String commentWriterEmail;
    private String commentContent;
    private String writerNickname;
    private String writerProfileImageUrl;
    private String writeDatetime;
}

