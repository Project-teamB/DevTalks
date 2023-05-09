package com.teamproject.devTalks.entity.hashTag;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity(name = "qnaHashtag")
@Table(name = "qnaHashtag")
public class QnaBoardHashTagEntity {
    
    @Id
    private String hashtag;
    @Id
    private int qnaBoardNumber;

}
