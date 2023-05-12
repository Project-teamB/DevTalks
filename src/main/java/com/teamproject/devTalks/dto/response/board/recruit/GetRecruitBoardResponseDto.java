package com.teamproject.devTalks.dto.response.board.recruit;

import java.util.ArrayList;
import java.util.List;

import com.teamproject.devTalks.dto.response.ResponseDto;
import com.teamproject.devTalks.entity.board.RecruitBoardEntity;
import com.teamproject.devTalks.entity.comment.RecruitCommentEntity;
import com.teamproject.devTalks.entity.hashTag.RecruitBoardHashTagEntity;
import com.teamproject.devTalks.entity.heart.RecruitHeartEntity;
import com.teamproject.devTalks.entity.user.UserEntity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetRecruitBoardResponseDto extends ResponseDto {
    private int recruitBoardNumber;
    private String recruitTitle;
    private String recruitContent;
    private String recruitBoardImageUrl;
    private String writeDatetime;
    private String writerEmail;
    private String writerNickname;
    private String writerProfileImageUrl;
    private int viewCount;
    private List<RecruitComment> commentList;
    private List<RecruitHeart> heartList;
    private String hashtag;

    public GetRecruitBoardResponseDto(
        RecruitBoardEntity recruitBoardEntity, UserEntity userEntity, RecruitBoardHashTagEntity recruitBoardHashTagEntity,
        List<RecruitCommentEntity> recruitCommentEntities, List<RecruitHeartEntity> recruitHeartEntities
    ) {
        super("SU", "Success");

        this.recruitBoardNumber = recruitBoardEntity.getRecruitBoardNumber();
        this.recruitTitle = recruitBoardEntity.getRecruitTitle();
        this.recruitContent = recruitBoardEntity.getRecruitContent();
        this.recruitBoardImageUrl = recruitBoardEntity.getRecruitBoardImageUrl();
        this.writeDatetime = recruitBoardEntity.getWriteDatetime();
        this.writerEmail = userEntity.getUserEmail();
        this.writerNickname = userEntity.getUserNickname();
        this.writerProfileImageUrl = userEntity.getUserProfileImageUrl();
        this.viewCount = recruitBoardEntity.getViewCount();
        this.commentList = RecruitComment.createList(recruitCommentEntities);
        this.heartList = RecruitHeart.createList(recruitHeartEntities);
        this.hashtag = recruitBoardHashTagEntity.getHashtag();

    }

}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class RecruitComment {
    private int recruitCommentNumber;
    private int recruitBoardNumber;
    private int userNumber;
    private String recruitCommentContent;
    private String writerEmail;
    private String writerNickname;
    private String writerProfileImageUrl;
    private String writeDatetime;
    private String updateDatetime;

    RecruitComment(RecruitCommentEntity recruitCommentEntity) {
        this.recruitCommentNumber = recruitCommentEntity.getRecruitCommentNumber();
        this.recruitBoardNumber = recruitCommentEntity.getRecruitBoardNumber();
        this.userNumber = recruitCommentEntity.getUserNumber();
        this.recruitCommentContent = recruitCommentEntity.getRecruitCommentContent();
        this.writerEmail = recruitCommentEntity.getWriterEmail();
        this.writerNickname = recruitCommentEntity.getWriterNickname();
        this.writerProfileImageUrl = recruitCommentEntity.getWriterProfileImageUrl();
        this.writeDatetime = recruitCommentEntity.getWriteDatetime();
        this.updateDatetime = recruitCommentEntity.getUpdateDatetime();
    }

    static List<RecruitComment> createList(List<RecruitCommentEntity> recruitCommentEntities) {
        List<RecruitComment> recruitCommentList = new ArrayList<>();
        for(RecruitCommentEntity recruitCommentEntity: recruitCommentEntities) {
            RecruitComment recruitComment = new RecruitComment(recruitCommentEntity);
            recruitCommentList.add(recruitComment);
        }
        return recruitCommentList;
    }

}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class RecruitHeart {
    private int recruitBoardNumber;
    private int userNumber;
    

    RecruitHeart(RecruitHeartEntity recruitHeartEntity) {
    this.recruitBoardNumber = recruitHeartEntity.getRecruitBoardNumber();
    this.userNumber = recruitHeartEntity.getUserNumber();
    }

    static List<RecruitHeart> createList(List<RecruitHeartEntity> recruitHeartEntities) {
        List<RecruitHeart> recruitHeartList = new ArrayList<>();
        for(RecruitHeartEntity recruitHeartEntity: recruitHeartEntities) {
            RecruitHeart recruitHeart = new RecruitHeart(recruitHeartEntity);
            recruitHeartList.add(recruitHeart);
        }
        return recruitHeartList;
    }

}

