package com.teamproject.devTalks.entity.primaryKey.teacher;

import java.io.Serializable;

import javax.persistence.Column;

public class TeacherHashTagPk implements Serializable{
    @Column(name = "teacherHashtag")
    private String hashtag;

    @Column(name = "teacherBoardNumber")
    private int teacherBoardNumber;
}
