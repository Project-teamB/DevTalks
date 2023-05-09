package com.teamproject.devTalks.entity.heart;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity(name = "qnaHeart")
@Table(name = "qnaHeart")
public class QnaHeartEntity {
    
    @Id
    private int userNumber;
    @Id
    private int qnaBoardNumber;


}
