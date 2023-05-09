package com.teamproject.devTalks.entity.comment;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.teamproject.devTalks.entity.primaryKey.recruit.RecruitCommentPk;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="RecruitComment")
@Table(name="RecruitComment")
@IdClass(RecruitCommentPk.class)
public class RecruitCommentEntity {
    @Id
    private int recruitBoardNumber;
    @Id
    private int userNumber;
    private String recruitCommentContent;
    private String writerNickname;
    private String writerEmail;
    private String writerProfileImageUrl;
    private String writeDatetime;
    private String updateDatetime;


}
