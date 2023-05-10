package com.teamproject.devTalks.service.implement.user;

import com.teamproject.devTalks.common.util.CustomResponse;
import com.teamproject.devTalks.dto.request.user.AdminSignUpRequestDto;
import com.teamproject.devTalks.dto.response.ResponseDto;
import com.teamproject.devTalks.entity.user.AdminEntity;
import com.teamproject.devTalks.provider.JwtProvider;
import com.teamproject.devTalks.repository.user.AdminRepository;
import com.teamproject.devTalks.service.user.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminServiceImplement implements AdminService {

    private final AdminRepository adminRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    @Override
    public ResponseEntity<ResponseDto> adminSignUp(AdminSignUpRequestDto dto) {

        String adminEmail = dto.getAdminEmail();
        String adminNickname = dto.getAdminNickname();
        String adminPhoneNumber = dto.getAdminPhoneNumber();

        String encodedPassword =passwordEncoder.encode(dto.getAdminPassword());
        dto.setAdminPassword(encodedPassword);

        try {

            boolean isExistEmail = adminRepository.existsByAdminEmail(adminEmail);
            if(isExistEmail) return CustomResponse.existEmail();

            boolean isExistNickname = adminRepository.existsByAdminNickname(adminNickname);
            if(isExistNickname) return CustomResponse.existNickname();

            boolean isExistPhoneNumber = adminRepository.existsByAdminPhoneNumber(adminPhoneNumber);
            if(isExistPhoneNumber) return CustomResponse.existPhoneNumber();

            AdminEntity adminEntity = new AdminEntity(dto);
            adminRepository.save(adminEntity);

        } catch (Exception exception){
            exception.printStackTrace();
            CustomResponse.databaseError();
        }

        return CustomResponse.success();
    }
}