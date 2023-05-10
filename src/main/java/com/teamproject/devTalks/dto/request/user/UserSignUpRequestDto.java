package com.teamproject.devTalks.dto.request.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSignUpRequestDto {
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
    @NotNull
    @Size(min = 0)
    private List<String> userHashtag;
    private boolean chatAcceptance;
    private boolean agreePersonalInformation;


}
