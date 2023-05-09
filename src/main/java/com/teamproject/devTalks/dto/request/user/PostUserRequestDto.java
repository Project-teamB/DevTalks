package com.teamproject.devTalks.dto.request.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostUserRequestDto {
    @NotBlank @Email
    private String userEmail;
    @NotBlank
    private String userPassword;
    @NotBlank
    private String userNickname;
    @NotBlank
    private String userName;
    @NotBlank
    private String userPhoneNumber;
    private String userIntroduction;
    private String userProfileImageUrl;
    private List<String> userHashtag; //TODO: 해시태그 리스트 어떻게 받아올지 몰라 우선 주석처리
    @NotNull
    private boolean chatAcceptance;


}
