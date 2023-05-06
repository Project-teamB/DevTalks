package com.teamproject.devTalks.entity.user;


import javax.persistence.*;

@Entity(name = "Admin")
@Table(name = "Adimin")
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
