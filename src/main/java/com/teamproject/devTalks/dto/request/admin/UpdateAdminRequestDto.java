package com.teamproject.devTalks.dto.request.admin;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class UpdateAdminRequestDto {

    @NotBlank
    private String password;
    @NotBlank
    private String adminNickname;
    @NotBlank
    private String adminPhoneNumber;
    private String adminProfileImageUrl;

}
