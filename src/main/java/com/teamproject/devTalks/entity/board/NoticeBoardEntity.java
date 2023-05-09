package com.teamproject.devTalks.entity.board;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "notice")
@Table(name = "notice")
public class NoticeBoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int noticeBoardNumber;
    private String writerEmail;
    private String writerNickname;
    private String writerProfileImageUrl;
    private int viewCount;
    private String noticeTitle;
    private String noticeContent;
    private String noticeImageUrl;
    private String writeDatetime;
    private String updateDatetime;

}
