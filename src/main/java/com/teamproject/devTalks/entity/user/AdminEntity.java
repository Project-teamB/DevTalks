package com.teamproject.devTalks.entity.user;


import javax.persistence.*;

import com.teamproject.devTalks.dto.request.admin.AdminSignUpRequestDto;
import lombok.*;

@Entity(name = "admin")
@Table(name = "admin")
@Getter
@Setter
@NoArgsConstructor
public class AdminEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adminNumber;
    private String adminEmail;
    private String adminPassword;
    private String adminNickname;
    private String adminPhoneNumber;
    private String adminName;
    private String adminProfileImageUrl;
    private boolean agreePersonalInformation;

    public AdminEntity(AdminSignUpRequestDto dto) {

        this.adminEmail = dto.getAdminEmail();
        this.adminPassword = dto.getAdminPassword();
        this.adminNickname = dto.getAdminNickname();
        this.adminPhoneNumber = dto.getAdminPhoneNumber();
        this.adminName = dto.getAdminName();
        this.agreePersonalInformation = dto.isAgreePersonalInformation();

    }
}
