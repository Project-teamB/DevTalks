package com.teamproject.devTalks.entity.user;


import javax.persistence.*;

import lombok.*;

@Entity(name = "Admin")
@Table(name = "Admin")
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
    private boolean agreePersonalInformation;

}
