package com.teamproject.devTalks.repository.hashTag;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.teamproject.devTalks.entity.hashTag.TeacherBoardHashTagEntity;
import com.teamproject.devTalks.entity.primaryKey.teacher.TeacherHeartPk;

@Repository
public interface TeacherBoardHashTagRepository extends JpaRepository<TeacherBoardHashTagEntity, TeacherHeartPk> {
    List<TeacherBoardHashTagEntity> findAllByHashtag(String hashtag);
}
