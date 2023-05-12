package com.teamproject.devTalks.repository.user;

import com.teamproject.devTalks.entity.user.BlackListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public interface BlackListRepository extends JpaRepository <BlackListEntity , Integer> {

    public boolean existsByUserNumber(Integer userNumber);
    public BlackListEntity findByUserNumber(Integer userNumber);



}
