package com.teamproject.devTalks.entity.hashTag;

import com.teamproject.devTalks.entity.primaryKey.user.UserHashTagPk;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Getter
@Setter
@Entity(name = "userHashTag")
@Table(name = "userHashtag")
@IdClass(UserHashTagPk.class)

public class UserHashTagEntity {
    @Id
    private int userNumber;
    @Id
    private String hashtag;

}
