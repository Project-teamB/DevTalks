package com.teamproject.devTalks.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teamproject.devTalks.entity.user.AdminEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository <AdminEntity,Integer>{

    public AdminEntity findByAdminEmail(String Email);

    boolean existsByAdminEmail(String email);
    boolean existsByAdminNickname(String nickname);
    boolean existsByAdminPhoneNumber(String phoneNumber);

}
