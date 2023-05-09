package com.teamproject.devTalks.entity.primaryKey.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.io.Serializable;

@Getter
@Setter
public class UserHashTagPk implements Serializable {

    @Column(name = "user_number")
    private int userNumber;
    @Column(name = "hashtag")
    private String hashtag;
}
