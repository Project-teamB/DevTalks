package com.teamproject.devTalks.entity.heart;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.ManyToOne;

import com.teamproject.devTalks.entity.board.InformationBoardEntity;
import com.teamproject.devTalks.entity.primaryKey.information.InformationHeartPk;
import com.teamproject.devTalks.entity.user.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="InformationHeart")
@Table(name="InformationHeart")
@IdClass(InformationHeartPk.class)
public class InformationHeartEntity {
    @Id
    private int informationBoardNumber;
    @Id
    private int userNumber;

    private boolean heartStatus;

    @ManyToOne
    private InformationBoardEntity informationBoardEntity;
    
    @ManyToOne
    private UserEntity userEntity;

    public InformationHeartEntity(UserEntity userEntity, InformationBoardEntity informationBoardEntity) {
        this.informationBoardNumber = informationBoardEntity.getInformationBoardNumber();
        this.userNumber = userEntity.getUserNumber();
        this.informationBoardEntity = informationBoardEntity;
        this.userEntity = userEntity;
        this.heartStatus = true; 
    }


}