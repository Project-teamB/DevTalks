package com.teamproject.devTalks.entity.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "getTeacherListView")
@Table(name = "getTeacherListView")
public class GetTeacherListViewEntity {
    @Id
    private int teacherBoardNumber;
    private String teacherBoardTitle;
    private String teacherBoardContent;
    private String teacherBoardImageUrl;
    private String writerNickname;
    private String writerEmail;
    private String writerProfileImageUrl;
    private String writeDatetime;
    private int viewCount;
    private int heartCount;
}
