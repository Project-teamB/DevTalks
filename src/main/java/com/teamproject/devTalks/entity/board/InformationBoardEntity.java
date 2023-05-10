package com.teamproject.devTalks.entity.board;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.teamproject.devTalks.dto.request.board.postBoard.PostInformationBoardRequestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "InformationBoard")
@Table(name = "InformationBoard")
public class InformationBoardEntity {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int informationBoardNumber;
    private String profileImageUrl;
    private String writerNickname;
    private String writerEmail;
    private String onformationBoardTitle;
    private String informationBoardContent;
    private String informationBoardImageUrl;
    private String contentSource;
    private int viewCount;

}

