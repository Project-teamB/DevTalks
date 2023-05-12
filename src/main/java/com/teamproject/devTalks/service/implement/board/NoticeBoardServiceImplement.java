package com.teamproject.devTalks.service.implement.board;

import com.teamproject.devTalks.common.util.CustomResponse;
import com.teamproject.devTalks.dto.request.board.notice.PostNoticeBoardRequestDto;
import com.teamproject.devTalks.dto.response.ResponseDto;
import com.teamproject.devTalks.dto.response.board.notice.GetNoticeBoardResponseDto;
import com.teamproject.devTalks.entity.board.NoticeBoardEntity;
import com.teamproject.devTalks.entity.user.AdminEntity;
import com.teamproject.devTalks.repository.board.NoticeBoardRepository;
import com.teamproject.devTalks.repository.user.AdminRepository;
import com.teamproject.devTalks.service.board.NoticeBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoticeBoardServiceImplement implements NoticeBoardService {

    private final NoticeBoardRepository noticeBoardRepository;
    private final AdminRepository adminRepository;

    @Override
    public ResponseEntity<ResponseDto> postNotice(String adminEmail, PostNoticeBoardRequestDto dto) {
        try {

            AdminEntity adminEntity = adminRepository.findByAdminEmail(adminEmail);
            if(adminEntity == null) return CustomResponse.authenticationFailed();

            NoticeBoardEntity noticeBoardEntity = new NoticeBoardEntity(dto,adminEntity);
            noticeBoardRepository.save(noticeBoardEntity);

        }catch (Exception exception) {
            exception.printStackTrace();
        }

        return CustomResponse.success();
    }

    @Override
    public ResponseEntity<? super GetNoticeBoardResponseDto> getBoard(Integer boardNumber) {

        GetNoticeBoardResponseDto body = null;

        try {
            if(boardNumber == null) return CustomResponse.validationFailed();

            NoticeBoardEntity noticeBoardEntity = noticeBoardRepository.findByNoticeBoardNumber(boardNumber);
            if(noticeBoardEntity == null) return CustomResponse.notExistBoardNumber();

            int viewCount = noticeBoardEntity.getViewCount();
            noticeBoardEntity.setViewCount(++viewCount);
            noticeBoardRepository.save(noticeBoardEntity);

            String writerEmail = noticeBoardEntity.getWriterEmail();
            AdminEntity adminEntity = adminRepository.findByAdminEmail(writerEmail);

            body = new GetNoticeBoardResponseDto(noticeBoardEntity,adminEntity);

        }catch (Exception exception){
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }

        return ResponseEntity.status(HttpStatus.OK).body(body);
    }


}
