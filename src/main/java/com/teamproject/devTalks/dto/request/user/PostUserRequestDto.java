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
    private List<String> userHashtag;
    private boolean chatAcceptance;
    @NotNull
    private boolean agreePersonalInformation;


}
