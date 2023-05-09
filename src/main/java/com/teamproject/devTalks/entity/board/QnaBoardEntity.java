package com.teamproject.devTalks.entity.board;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity(name="qna")
@Table(name="qna")
public class QnaBoardEntity {
    
    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ai
    private int qnaBoardNumber;
    private String writerProfileImageUrl;
    private String writerNickname;
    private String writerDatetime;
    private String qnaTitle;
    private String qnaContent;
    private String qnaBoardImageUrl;
    

}
