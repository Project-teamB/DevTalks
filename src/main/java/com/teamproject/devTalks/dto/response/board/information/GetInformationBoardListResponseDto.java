package com.teamproject.devTalks.dto.response.board.information;

import java.util.ArrayList;
import java.util.List;

import com.teamproject.devTalks.dto.response.ResponseDto;
import com.teamproject.devTalks.entity.resultSet.InformationBoardListResultSet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class GetInformationBoardListResponseDto extends ResponseDto {

    private List<BoardSummary> boardList;

    public GetInformationBoardListResponseDto(List<InformationBoardListResultSet> resultSet) {
        super("SU", "Success");

        List<BoardSummary> boardList = new ArrayList<>();
    
        if (resultSet != null) {
            for (InformationBoardListResultSet result : resultSet) {
                BoardSummary boardSummary = new BoardSummary(result);
                boardList.add(boardSummary);
            }
        }
    
        this.boardList = boardList;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    class BoardSummary {
        private int informationBoardNumber;
        private String writerProfileImageUrl;
        private String writerNickname;
        private String writerEmail;
        private String informationBoardTitle;
        private String writeDatetime;
        private int viewCount;
        private int commentCount;
        private int heartCount;

        public BoardSummary(InformationBoardListResultSet resultSet) {
            this.informationBoardNumber = resultSet.getInformationBoardNumber();
            this.writerProfileImageUrl = resultSet.getWriterProfileImageUrl();
            this.writerNickname = resultSet.getWriterNickname();
            this.writerEmail = resultSet.getWriterEmail();
            this.informationBoardTitle = resultSet.getInformationBoardTitle();
            this.viewCount = resultSet.getViewCount();
            this.writeDatetime = resultSet.getWriteDatetime();            
            this.commentCount = resultSet.getCommentCount();
            this.heartCount = resultSet.getHeartCount();
        }
    }
}
