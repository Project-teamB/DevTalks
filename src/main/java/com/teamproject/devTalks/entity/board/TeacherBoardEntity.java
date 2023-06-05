package com.teamproject.devTalks.entity.board;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.teamproject.devTalks.dto.request.board.teacher.PatchTeacherBoardRequestDto;
import com.teamproject.devTalks.dto.request.board.teacher.PostTeacherBoardRequestDto;
import com.teamproject.devTalks.entity.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "teacher")
@Table(name = "teacher")
public class TeacherBoardEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teacherBoardNumber;
    private String teacherTitle;
    private String writeDatetime;
    private int viewCount;
    private String writerEmail;
    private String writerNickname;
    private String writerProfileImageUrl;
    
    private String teacherContent;
    private String teacherBoardImageUrl;
    private String career;
    private String lectureUrl;
    private String category;

    public TeacherBoardEntity(UserEntity userEntity, PostTeacherBoardRequestDto dto) {
        Date now = new Date();
        SimpleDateFormat simpleDateFormat = 
            new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String writeDatetime = simpleDateFormat.format(now);

        this.teacherTitle = dto.getTeacherTitle();
        this.writeDatetime = writeDatetime;
        this.viewCount = 0;
        this.writerEmail = userEntity.getUserEmail();
        this.writerNickname = userEntity.getUserNickname();
        this.writerProfileImageUrl = userEntity.getUserProfileImageUrl();
        this.teacherContent = dto.getTeacherContent();
        this.teacherBoardImageUrl = dto.getTeacherBoardImageUrl();
        this.career = dto.getCareer();
        this.lectureUrl = dto.getLectureUrl();
    }

    public TeacherBoardEntity(UserEntity userEntity, PatchTeacherBoardRequestDto dto) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        this.teacherBoardNumber = getTeacherBoardNumber();
        this.teacherTitle = dto.getTeacherTitle();
        this.writeDatetime = now.format(formatter);
        this.writerEmail = userEntity.getUserEmail();
        this.writerNickname = userEntity.getUserNickname();
        this.teacherContent = dto.getTeacherContent();
        this.teacherBoardImageUrl = dto.getTeacherBoardImageUrl();
        this.career = dto.getCareer();
        this.lectureUrl = dto.getLectureUrl();
    }
}
