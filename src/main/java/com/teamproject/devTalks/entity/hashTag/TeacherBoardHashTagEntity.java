package com.teamproject.devTalks.entity.hashTag;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import com.teamproject.devTalks.entity.primaryKey.teacher.TeacherHashTagPk;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="TeacherHashtag")
@Table(name="TeacherHashtag")
@IdClass(TeacherHashTagPk.class)
public class TeacherBoardHashTagEntity {
    @Id
    private int teacherBoardNumber;
    @Id
    private String hashtag;
}
