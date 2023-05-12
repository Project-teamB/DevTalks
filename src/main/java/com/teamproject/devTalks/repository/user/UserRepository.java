package com.teamproject.devTalks.repository.user;

import com.teamproject.devTalks.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    public boolean existsByUserEmail(String userEmail);
    public boolean existsByUserNickname(String userNickname);
    public boolean existsByUserPhoneNumber(String userPhoneNumber);
    public boolean existsByUserNumber(Integer userNumber);

    public UserEntity findByUserEmail(String Email);
    public UserEntity findByUserNumber(Integer userNumber);
    @Transactional
    public void deleteByUserEmail(String userEmail);
}
