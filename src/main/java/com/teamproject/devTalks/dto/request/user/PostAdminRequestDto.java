package com.teamproject.devTalks.dto.request.user;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Getter
@Setter
@NoArgsConstructor
public class PostAdminRequestDto {

    @NotBlank @Email
    private String adminEmail;
    @NotBlank
    private String adminPassword;
    @NotBlank
    private String adminNickname;
    @NotBlank
    private String adminPhoneNumber;
    @NotBlank
    private String adminName;


}
