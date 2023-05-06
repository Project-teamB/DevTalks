package com.teamproject.devTalks.dto.request.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostUserRequestDto {

    private String userEmail;
    private String userPassword;
    private String userNickname;
    private String userName;
    private String userPhoneNumber;
    private String userIntroduction;
    private List userHashtag;
    private boolean chatAcceptance;


}
