package com.teamproject.devTalks.dto.request.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminSignInRequestDto {

    private String adminEmail;
    private String adminPassword;
}
