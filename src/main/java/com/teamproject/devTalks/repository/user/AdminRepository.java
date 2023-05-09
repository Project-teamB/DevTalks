package com.teamproject.devTalks.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teamproject.devTalks.entity.user.AdminEntity;

public interface AdminRepository extends JpaRepository {

    public AdminEntity findByAdminEmail(String Email);
    
}
