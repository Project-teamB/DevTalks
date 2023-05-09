package com.teamproject.devTalks.repository.hashTag;

import com.teamproject.devTalks.entity.hashTag.UserHashTagEntity;
import com.teamproject.devTalks.entity.primaryKey.user.UserHashTagPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserHashTagRepository extends JpaRepository<UserHashTagEntity, UserHashTagPk> {
    
}
