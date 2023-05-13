package com.teamproject.devTalks.dto.response.board.information;

import java.util.ArrayList;
import java.util.List;

import com.teamproject.devTalks.dto.response.ResponseDto;
import com.teamproject.devTalks.entity.board.InformationBoardEntity;
import com.teamproject.devTalks.entity.comment.InformationCommentEntity;
import com.teamproject.devTalks.entity.heart.InformationHeartEntity;
import com.teamproject.devTalks.entity.user.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetInformationBoardResponseDto extends ResponseDto {
    private int informationBoardNumber;
    private String writerProfileImageUrl;
    private String writerNickname;
    private String writerEmail;
    private String informationBoardTitle;
    private String informationBoardContent;
    private String informationBoardImageUrl;
    private String contentSource;
    private int viewCount;
    private String writeDatetime;
    private String updateDatetime;
    private List<InformationComment> informationCommentList;
    private List<InformationHeart> informationHeartList;

    public GetInformationBoardResponseDto(
        InformationBoardEntity informationBoardEntity, UserEntity userEntity,
        List<InformationCommentEntity> informationCommentEntities, List<InformationHeartEntity> informationHeartEntities    
) {
        super("SU", "Success");

        this.informationBoardNumber = informationBoardEntity.getInformationBoardNumber();
        this.writerProfileImageUrl = userEntity.getUserProfileImageUrl();
        this.writerNickname = userEntity.getUserNickname();
        this.writerEmail = userEntity.getUserEmail();
        this.informationBoardTitle = informationBoardEntity.getInformationBoardTitle();
        this.informationBoardContent = informationBoardEntity.getInformationBoardContent();
        this.informationBoardImageUrl = informationBoardEntity.getInformationBoardImageUrl();
        this.contentSource = informationBoardEntity.getContentSource();
        this.viewCount = informationBoardEntity.getViewCount();
        this.writeDatetime = informationBoardEntity.getWriteDatetime();
        this.updateDatetime = informationBoardEntity.getUpdateDatetime();
        this.informationCommentList = createInformationCommentList(informationCommentEntities);
        this.informationHeartList = createInformationHeartList(informationHeartEntities);
   
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class InformationComment {
        private int informationCommentNumber;
        private String informationCommentContent;
        private String informationCommentWriterNickname;
        private String informationCommentWriterEmail;
        private String informationCommentWriterProfileImageUrl;
        private String informationCommentWriteDatetime;
        private int informationBoardNumber;
    
        public InformationComment(InformationCommentEntity informationCommentEntity) {
            this.informationCommentNumber = informationCommentEntity.getInformationCommentNumber();
            this.informationCommentContent = informationCommentEntity.getInformationCommentContent();
            this.informationCommentWriterNickname = informationCommentEntity.getWriterNickname();
            this.informationCommentWriterEmail = informationCommentEntity.getWriterEmail();
            this.informationCommentWriterProfileImageUrl = informationCommentEntity.getWriterProfileImageUrl();
            this.informationCommentWriteDatetime = informationCommentEntity.getWriteDatetime();
            this.informationBoardNumber = informationCommentEntity.getInformationBoardNumber();
        }
    }
    
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class InformationHeart {
        private int informationBoardNumber;
        private int userNumber;
    
        public InformationHeart(InformationHeartEntity informationHeartEntity) {
            this.informationBoardNumber = informationHeartEntity.getInformationBoardNumber();
            this.userNumber = informationHeartEntity.getUserNumber();
        }
    }
    
    private List<InformationComment> createInformationCommentList(List<InformationCommentEntity> informationCommentEntities) {
        List<InformationComment> informationCommentList = new ArrayList<>();
        for (InformationCommentEntity informationCommentEntity : informationCommentEntities) {
            InformationComment informationComment = new InformationComment(informationCommentEntity);
            informationCommentList.add(informationComment);
        }
        return informationCommentList;
    }
    
    private List<InformationHeart> createInformationHeartList(List<InformationHeartEntity> informationHeartEntities) {
        List<InformationHeart> informationHeartList = new ArrayList<>();
        for (InformationHeartEntity informationHeartEntity : informationHeartEntities) {
            InformationHeart informationHeart = new InformationHeart(informationHeartEntity);
            informationHeartList.add(informationHeart);
        }
        return informationHeartList;
    }
}    
