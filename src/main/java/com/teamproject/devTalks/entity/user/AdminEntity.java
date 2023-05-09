package com.teamproject.devTalks.entity.user;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Admin")
@Table(name = "Admin")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adminNumber;
    private String adminEmail;
    private String adminPassword;
    private String adminNickname;
    private String adminPhoneNumber;
    private String adminName;

}
