package com.teamproject.devTalks.entity.comment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.teamproject.devTalks.entity.primaryKey.information.InformationCommentPk;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="InformationComment")
@Table(name="InformationComment")
@IdClass(InformationCommentPk.class)
public class InformationCommentEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int informationCommentNumber;
    private String informationCommentContent;
    private String writerNickname;
    private String writerEmail;
    private String writerProfileImageUrl;
    private String writeDatetime;
    private String updateDatetime;
    private int userNumber;
    private int informationBoardNumber;

}
