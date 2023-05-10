package com.teamproject.devTalks.repository.user;

import com.teamproject.devTalks.entity.user.BlackListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;


public interface BlackListRepository extends JpaRepository <BlackListEntity , Integer> {


}
