package com.teamproject.devTalks.entity.comment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity(name = "qnaComment")
@Table(name = "qnaComment")
public class QnaCommentEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int qnaCommentNumber;
    private String commentContent;
    private String writerProfileImageUrl;
    private String writerNickname;
    private String writerEmail;
    private String writeDatetime;
    private String userNumber;
    private String quaBoardNumber;

}
