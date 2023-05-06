package com.teamproject.devTalks.entity.user;


import com.teamproject.devTalks.entity.hashTag.UserHashTagEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "User")
@Table(name ="User")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userNumber;
    private String userEmail;
    private String UserPassword;
    private String userNickname;
    private String userName;
    private String userPhoneNumber;
    private String userIntroduction;
    private String userProfileImageUrl;
    private boolean chatAcceptance;
    private String createdAt;
    private String updatedAt;










    
}
