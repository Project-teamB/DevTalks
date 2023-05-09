package com.teamproject.devTalks.service.implement.board;

import com.teamproject.devTalks.common.util.CustomResponse;
import com.teamproject.devTalks.dto.response.board.GetNoticeBoardResponseDto;
import com.teamproject.devTalks.entity.board.NoticeBoardEntity;
import com.teamproject.devTalks.entity.user.AdminEntity;
import com.teamproject.devTalks.repository.board.NoticeBoardRepository;
import com.teamproject.devTalks.repository.user.AdminRepository;
import com.teamproject.devTalks.service.board.NoticeBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoticeBoardServiceImplement implements NoticeBoardService {

    private final NoticeBoardRepository noticeBoardRepository;
    private final AdminRepository adminRepository;

    @Override
    public ResponseEntity<? super GetNoticeBoardResponseDto> getBoard(Integer boardNumber) {

        GetNoticeBoardResponseDto body = null;
        try {
            if(boardNumber == null) return CustomResponse.validationFailed();

            NoticeBoardEntity noticeBoardEntity = noticeBoardRepository.findByBoardNumber(boardNumber);
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
