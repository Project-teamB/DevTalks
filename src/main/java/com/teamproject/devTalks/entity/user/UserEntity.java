package com.teamproject.devTalks.entity.user;

import com.teamproject.devTalks.dto.request.user.UserSignUpRequestDto;
import com.teamproject.devTalks.entity.hashTag.UserHashTagEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    private boolean agreePersonalInformation;
    private boolean chatAcceptance;
    private String createdAt;
    private String updatedAt;

    public UserEntity(UserSignUpRequestDto dto) {

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        this.userEmail = dto.getUserEmail();
        this.UserPassword = dto.getUserPassword();
        this.userNickname = dto.getUserNickname();
        this.userName = dto.getUserName();
        this.userPhoneNumber = dto.getUserPhoneNumber();
        this.userIntroduction = dto.getUserIntroduction();
        this.userProfileImageUrl = dto.getUserProfileImageUrl();
        this.chatAcceptance = dto.isChatAcceptance();
        this.agreePersonalInformation = dto.isAgreePersonalInformation();
        this.createdAt = now.format(formatter);

    }
}
