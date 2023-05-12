package com.teamproject.devTalks.dto.response.board.informaion;

import com.teamproject.devTalks.dto.response.ResponseDto;
import com.teamproject.devTalks.entity.board.InformationBoardEntity;
import com.teamproject.devTalks.entity.user.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetInformationBoardResponseDto extends ResponseDto {

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

    public GetInformationBoardResponseDto(
        InformationBoardEntity informationBoardEntity, UserEntity userEntity        
    ) {
        super("SU", "Success");

    this.informationBoardNumber = informationBoardEntity.getInformationBoardNumber();
    this.writerProfileImageUrl = userEntity.getUserProfileImageUrl();
    this.writerNickname = userEntity.getUserNickname();
    this.writerEmail = userEntity.getUserEmail();
    this.informationBoardTitle = informationBoardEntity.getInformationBoardTitle();
    this.informationBoardContent = informationBoardEntity.getInformationBoardContent();
    this.informationBoardImageUrl = informationBoardEntity.getInformationBoardImageUrl();
    this.contentSource = informationBoardEntity.getContentSource();
    this.viewCount = informationBoardEntity.getViewCount();
    this.writeDatetime = informationBoardEntity.getWriteDatetime();
    this.updateDatetime = informationBoardEntity.getUpdateDatetime();
    }
}