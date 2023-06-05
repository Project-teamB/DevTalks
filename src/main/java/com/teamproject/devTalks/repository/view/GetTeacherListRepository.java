package com.teamproject.devTalks.repository.view;

import com.teamproject.devTalks.entity.view.GetTeacherListViewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GetTeacherListRepository extends JpaRepository<GetTeacherListViewEntity,Integer> {

    public List<GetTeacherListViewEntity> findByOrderByWriteDatetimeDesc();
    public List<GetTeacherListViewEntity> findByOrderByHeartCountDesc();
    public List<GetTeacherListViewEntity> findByOrderByViewCountDesc();

}
