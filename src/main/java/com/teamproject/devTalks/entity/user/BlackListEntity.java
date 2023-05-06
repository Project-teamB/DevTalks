package com.teamproject.devTalks.entity.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "blacklist")
@Table(name = "blacklist")
public class BlackListEntity {

    @Id
    private int userNumber;
    private String reason;
    private String createdAt;
    private String updatedAt;



    
}
