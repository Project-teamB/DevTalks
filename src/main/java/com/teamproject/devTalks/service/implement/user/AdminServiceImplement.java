package com.teamproject.devTalks.service.implement.user;

import com.teamproject.devTalks.common.util.CustomResponse;
import com.teamproject.devTalks.dto.request.admin.*;
import com.teamproject.devTalks.dto.response.ResponseDto;
import com.teamproject.devTalks.dto.response.user.AdminSignInResponseDto;
import com.teamproject.devTalks.dto.response.user.GetAdminInfoResponseDto;
import com.teamproject.devTalks.entity.user.AdminEntity;
import com.teamproject.devTalks.provider.JwtProvider;
import com.teamproject.devTalks.repository.user.AdminRepository;
import com.teamproject.devTalks.service.user.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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

    @Override
    public ResponseEntity<? super AdminSignInResponseDto> adminSignIn(AdminSignInRequestDto dto) {

        AdminSignInResponseDto body = null;
        String adminEmail = dto.getAdminEmail();
        String password = dto.getAdminPassword();
        String ROLE = "ADMIN";

        try {

            AdminEntity adminEntity = adminRepository.findByAdminEmail(adminEmail);
            if(adminEntity == null) return CustomResponse.signInFailed();

            String encodedPassword = adminEntity.getAdminPassword();
            boolean isEqualPassword = passwordEncoder.matches(password,encodedPassword);

            if(!isEqualPassword) return CustomResponse.signInFailed();

            String jwt = jwtProvider.createJwt(adminEmail,ROLE);
            body = new AdminSignInResponseDto(jwt);

        }catch (Exception exception){
            exception.printStackTrace();
            CustomResponse.databaseError();
        }

        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    @Override
    public ResponseEntity<ResponseDto> adminUpdate(
            String adminEmail, UpdateAdminRequestDto dto) {

        String password = dto.getPassword();
        String adminNickname = dto.getAdminNickname();
        String adminPhoneNumber = dto.getAdminPhoneNumber();

        try {

            AdminEntity adminEntity = adminRepository.findByAdminEmail(adminEmail);
            if(adminEntity == null) return CustomResponse.authenticationFailed();

            String encodedPassword = adminEntity.getAdminPassword();
            boolean isEqualPassword = passwordEncoder.matches(password,encodedPassword);

            if(!isEqualPassword) CustomResponse.passwordMismatch();

            boolean isExistNickname = adminRepository.existsByAdminNickname(adminNickname);
            if(isExistNickname) return CustomResponse.existNickname();
            adminEntity.setAdminNickname(adminNickname);

            boolean isExistPhoneNumber = adminRepository.existsByAdminPhoneNumber(adminPhoneNumber);
            if(isExistPhoneNumber) return CustomResponse.existPhoneNumber();
            adminEntity.setAdminPhoneNumber(adminPhoneNumber);

            adminRepository.save(adminEntity);

        }catch (Exception exception){
            exception.printStackTrace();
            CustomResponse.databaseError();
        }
        return CustomResponse.success();
    }

    @Override
    public ResponseEntity<ResponseDto> updateAdminPassword(
            String adminEmail, UpdateAdminPasswordRequestDto dto
    ) {

        String currentPassword = dto.getCurrentPassword();
        String changePassword = dto.getChangePassword();

        try {

            AdminEntity adminEntity = adminRepository.findByAdminEmail(adminEmail);
            if(adminEntity == null) return CustomResponse.authenticationFailed();

            String encodedCurrentPassword = adminEntity.getAdminPassword();

            boolean isEqualPassword  = passwordEncoder.matches(currentPassword,encodedCurrentPassword);
            if(!isEqualPassword) return CustomResponse.passwordMismatch();

            String encodedChangePassword = passwordEncoder.encode(changePassword);
            adminEntity.setAdminPassword(encodedChangePassword);

            adminRepository.save(adminEntity);

        }catch (Exception exception){
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }

        return CustomResponse.success();
    }

    @Override
    public ResponseEntity<ResponseDto> deleteAdmin(
            String adminEmail, DeleteAdminRequestDto dto) {

        String password = dto.getAdminPassword();


        try {

            AdminEntity adminEntity = adminRepository.findByAdminEmail(adminEmail);
            if(adminEntity == null) CustomResponse.authenticationFailed();

            String encodedPassword = adminEntity.getAdminPassword();
            boolean isEqualPassword = passwordEncoder.matches(password,encodedPassword);

            if(!isEqualPassword) return CustomResponse.passwordMismatch();
            adminRepository.deleteByAdminEmail(adminEmail);


        }catch (Exception exception){
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }


        return CustomResponse.success();
    }

    @Override
    public ResponseEntity<? super GetAdminInfoResponseDto> getAdminUpdate(String adminEmail) {

        GetAdminInfoResponseDto body = null;

        try {

            AdminEntity adminEntity = adminRepository.findByAdminEmail(adminEmail);
            if(adminEntity == null) return CustomResponse.authenticationFailed();

            body = new GetAdminInfoResponseDto(adminEntity);

        }catch (Exception exception){
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }


}