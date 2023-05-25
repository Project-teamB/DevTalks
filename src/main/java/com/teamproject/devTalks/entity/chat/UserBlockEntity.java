package com.teamproject.devTalks.entity.chat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "user_block")
@Table(name = "user_block")
public class UserBlockEntity {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int senderNumber;
    private int receiverNumber;
}
