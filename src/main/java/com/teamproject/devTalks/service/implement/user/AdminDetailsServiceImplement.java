package com.teamproject.devTalks.service.implement.user;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.teamproject.devTalks.entity.user.AdminEntity;
import com.teamproject.devTalks.repository.user.AdminRepository;


public class AdminDetailsServiceImplement implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AdminEntity admin = adminRepository.findByAdminEmail(email);
        if (admin == null) {
            throw new UsernameNotFoundException("Admin not found with email : " + email);
        }
        return new AdminPrinciple(admin);
    }
    
}
