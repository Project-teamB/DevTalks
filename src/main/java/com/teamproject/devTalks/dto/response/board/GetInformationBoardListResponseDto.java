package com.teamproject.devTalks.dto.response.board;

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

    private List<InformationBoardSummary> informationBoardList;

    public GetInformationBoardListResponseDto(List<InformationBoardListResultSet> resultSet) {
        super("SU", "Success");

        List<InformationBoardSummary> informationBoardList = new ArrayList<>();

        for (InformationBoardListResultSet result: resultSet) {
            InformationBoardSummary boardSummary = new InformationBoardSummary(result);
            informationBoardList.add(boardSummary);
        }

        this.informationBoardList = informationBoardList;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    class InformationBoardSummary {
        private int informationBoardNumber;
        private String informationBoardTitle;
        private String informationBoardContent;
        private String writeDatetime;
        private int viewCount;
        private String writerNickname;
        private String writerProfileImageUrl;
        private int commentCount;
        private int heartCount;
        private String informationBoardHashtag;

        public InformationBoardSummary(InformationBoardListResultSet resultSet) {
            this.informationBoardNumber = resultSet.getInformationBoardNumber();
            this.informationBoardTitle = resultSet.getInformationBoardTitle();
            this.informationBoardContent = resultSet.getInformationBoardContent();
            this.writeDatetime = resultSet.getWriteDatetime();
            this.viewCount = resultSet.getViewCount();
            this.writerNickname = resultSet.getWriterNickname();
            this.writerProfileImageUrl = resultSet.getWriterProfileImageUrl();
            this.commentCount = resultSet.getCommentCount();
            this.heartCount = resultSet.getHeartCount();
            this.informationBoardHashtag = resultSet.getInformationBoardHashtag();
        }
    }
}
