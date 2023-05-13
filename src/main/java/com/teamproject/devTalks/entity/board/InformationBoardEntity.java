package com.teamproject.devTalks.entity.board;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.teamproject.devTalks.dto.request.board.information.PostInformationBoardRequestDto;

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
    private String writerProfileImageUrl;
    private String writerNickname;
    private String writerEmail;
    private String informationBoardTitle;
    private String informationBoardContent;
    private String informationBoardImageUrl;
    private String contentSource;
    private int viewCount;
    private String writeDatetime;
    private String updateDatetime;

    public InformationBoardEntity(String userEmail, PostInformationBoardRequestDto dto) {
        Date now = new Date();
        SimpleDateFormat simpleDateFormat = 
            new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String writeDatetime = simpleDateFormat.format(now);

        this.writerProfileImageUrl = getWriterProfileImageUrl();
        this.writerNickname = getWriterNickname();
        this.writerEmail = getWriterEmail();
        this.informationBoardTitle = dto.getInformationBoardTitle();
        this.informationBoardContent = dto.getInformationBoardContent();
        this.informationBoardImageUrl = dto.getInformationBoardImageUrl();
        this.contentSource = dto.getContentSource();
        this.viewCount = 0;
        this.writeDatetime = writeDatetime;
    }
   
}

