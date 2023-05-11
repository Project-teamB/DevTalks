package com.teamproject.devTalks.entity.board;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "teacher")
@Table(name = "teacher")
public class TeacherBoardEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teacherBoardNumber;
    private String writerProfileImageUrl;
    private String writerEmail;
    private String writerNickname;
    private String writeDatetime;
    private String teacherTitle;
    private String teacherContent;
    private String teacherBoardImageUrl;
    private String career;
    private String lectureUrl;
    private int viewCount;
    private String category;
}
