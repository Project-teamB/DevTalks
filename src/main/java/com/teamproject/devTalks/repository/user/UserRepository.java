package com.teamproject.devTalks.repository.user;

import com.teamproject.devTalks.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    public boolean existsByUserEmail(String userEmail);
    public boolean existsByUserNickname(String userNickname);
    public boolean existsByUserPhoneNumber(String userPhoneNumber);

    public UserEntity findByUserEmail(String Email);
}
