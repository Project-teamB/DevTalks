package com.teamproject.devTalks.entity.heart;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.teamproject.devTalks.entity.primaryKey.qna.QnaHeartPk;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "qnaHeart")
@Table(name = "qnaHeart")
@IdClass(QnaHeartPk.class)
public class QnaHeartEntity {
    
    @Id
    private int userNumber;
    @Id
    private int qnaBoardNumber;


}
