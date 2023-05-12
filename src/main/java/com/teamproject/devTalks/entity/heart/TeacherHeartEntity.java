package com.teamproject.devTalks.entity.heart;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import com.teamproject.devTalks.entity.primaryKey.teacher.TeacherHeartPk;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "teacherHeart")
@Table(name = "teacherHeart")
@IdClass(TeacherHeartPk.class)
public class TeacherHeartEntity {
    @Id
    private int userNumber;
    @Id
    private int teacherBoardNumber;
}
