package com.teamproject.devTalks.dto.response.user;

import com.teamproject.devTalks.dto.response.ResponseDto;
import com.teamproject.devTalks.entity.user.AdminEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateAdminResponseDto extends ResponseDto {

    private int adminNumber;
    private String adminEmail;
    private String adminNickname;
    private String adminPhoneNumber;
    private String adminProfileImageUrl;

    public UpdateAdminResponseDto(AdminEntity adminEntity) {
        super("SU", "Success");
    }
}