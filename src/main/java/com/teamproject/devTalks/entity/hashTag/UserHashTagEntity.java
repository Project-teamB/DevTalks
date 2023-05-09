package com.teamproject.devTalks.entity.hashTag;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Getter
@Setter
@Entity(name = "userHashtag")
@Table(name = "userHashtag")
//IdClass() pk용 클래스 만들어서 작성

public class UserHashTagEntity {
    @Id
    private int userNumber;
    @Id
    private String hashTag;
    
}
