package com.teamproject.devTalks.dto.response.board.qna;

import java.util.ArrayList;
import java.util.List;

import com.teamproject.devTalks.dto.response.ResponseDto;
import com.teamproject.devTalks.entity.board.QnaBoardEntity;
import com.teamproject.devTalks.entity.comment.QnaCommentEntity;
import com.teamproject.devTalks.entity.heart.QnaHeartEntity;
import com.teamproject.devTalks.entity.user.UserEntity;

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
    private int qnaHeartCount;

    public GetQnaBoardResponseDto(
        QnaBoardEntity qnaBoardEntity, UserEntity userEntity, List<QnaCommentEntity> qnaCommentEntities, int qnaHeartCount
        ){
            super("SU", "Success");


            this.qnaBoardNumber = qnaBoardEntity.getQnaBoardNumber();
            this.qnaTitle = qnaBoardEntity.getQnaTitle();
            this.qnaContent = qnaBoardEntity.getQnaContent();
            this.qnaBoardImageUrl = qnaBoardEntity.getQnaBoardImageUrl();
            this.writeDatetime = qnaBoardEntity.getWriteDatetime();
            this.viewCount = qnaBoardEntity.getViewCount();
            this.writerNickname = qnaBoardEntity.getWriterNickname();
            this.writerProfileImageUrl = qnaBoardEntity.getWriterProfileImageUrl();
            this.commentList = createQnaCommentList(qnaCommentEntities);
            this.qnaHeartCount = qnaHeartCount;// 이거의 개수가 필요 
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

    public Comment(QnaCommentEntity qnaCommentEntity) {

        this.qnaCommentNumber = qnaCommentEntity.getQnaBoardNumber();
        this.qnaBoardNumber = qnaCommentEntity.getQnaBoardNumber();
        this.commentWriterEmail = qnaCommentEntity.getWriterEmail();;
        this.commentContent = qnaCommentEntity.getCommentContent();
        this.writerNickname = qnaCommentEntity.getWriterNickname();
        this.writerProfileImageUrl = qnaCommentEntity.getWriterProfileImageUrl();
        this.writeDatetime = qnaCommentEntity.getWriteDatetime();

        }

    }
@Data
@NoArgsConstructor
@AllArgsConstructor
    class Heart {

        private int userNumber;
        private int qnaBoardNumber;

        public Heart(QnaHeartEntity qnaHeartEntity){
            this.userNumber = qnaHeartEntity.getUserNumber();
            this.qnaBoardNumber = qnaHeartEntity.getQnaBoardNumber();
        }

    }



    private List<Comment> createQnaCommentList(List<QnaCommentEntity> qnaCommentEntities){

        List<Comment> qnaCommentList = new ArrayList<>();
        for(QnaCommentEntity qnaComments:qnaCommentEntities){

            Comment qnaComment = new Comment(qnaComments);
            qnaCommentList.add(qnaComment);
        }
        return qnaCommentList;
    }


}




