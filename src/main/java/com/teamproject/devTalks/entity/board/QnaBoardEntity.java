package com.teamproject.devTalks.entity.board;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.teamproject.devTalks.dto.request.board.qna.PatchQnaBoardRequestDto;
import com.teamproject.devTalks.dto.request.board.qna.PostQnaBoardRequestDto;
import com.teamproject.devTalks.entity.user.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity(name = "qna")
@Table(name = "qna")
public class QnaBoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int qnaBoardNumber;
    private String writerProfileImageUrl;
    private String writerEmail;
    private String writerNickname;
    private String writeDatetime;
    private String qnaTitle;
    private String qnaContent;
    private String qnaBoardImageUrl;
    private int viewCount;

    public QnaBoardEntity(UserEntity userEntity, PostQnaBoardRequestDto dto) {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        this.writerProfileImageUrl = userEntity.getUserProfileImageUrl();
        this.writerEmail = userEntity.getUserEmail();
        this.writerNickname = userEntity.getUserNickname();
        this.writeDatetime = dateFormat.format(now);
        this.qnaTitle = dto.getQnaTitle();
        this.qnaContent = dto.getQnaContent();
        this.qnaBoardImageUrl = dto.getQnaBoardImageUrl();
        this.viewCount = 0;
    }

    public QnaBoardEntity(UserEntity userEntity, PatchQnaBoardRequestDto dto) {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        this.writerProfileImageUrl = userEntity.getUserProfileImageUrl();
        this.writerNickname = userEntity.getUserNickname();
        this.writeDatetime = dateFormat.format(now);
        this.qnaTitle = dto.getQnaTitle();
        this.qnaContent = dto.getQnaContent();
        this.qnaBoardImageUrl = dto.getQnaBoardImageUrl();
    }

}
