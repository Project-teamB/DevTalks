package com.teamproject.devTalks.service.implement.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.teamproject.devTalks.dto.response.ResponseDto;
import com.teamproject.devTalks.repository.board.InformationBoardRepository;
import com.teamproject.devTalks.repository.comment.InformationCommentRepository;
import com.teamproject.devTalks.repository.heart.InformationHeartRepository;
import com.teamproject.devTalks.repository.user.UserRepository;
import com.teamproject.devTalks.dto.response.board.information.GetInformationBoardListResponseDto;
import com.teamproject.devTalks.dto.response.board.information.GetInformationBoardResponseDto;
import com.teamproject.devTalks.entity.board.InformationBoardEntity;
import com.teamproject.devTalks.entity.comment.InformationCommentEntity;
import com.teamproject.devTalks.entity.heart.InformationHeartEntity;
import com.teamproject.devTalks.entity.user.UserEntity;
import com.teamproject.devTalks.service.board.InformationBoardService;
import com.teamproject.devTalks.common.util.CustomResponse;
import com.teamproject.devTalks.dto.request.board.information.PatchInformationBoardRequestDto;
import com.teamproject.devTalks.dto.request.board.information.PostInformationBoardRequestDto;
import com.teamproject.devTalks.dto.request.comment.information.PatchInformationCommentRequestDto;
import com.teamproject.devTalks.dto.request.comment.information.PostInformationCommentRequestDto;
import com.teamproject.devTalks.dto.request.heart.information.PostInformationHeartRequestDto;

@Service
public class InformationBoardServiceImplement implements InformationBoardService {
    
    private UserRepository userRepository;
    private InformationBoardRepository informationBoardRepository;
    private InformationCommentRepository informationCommentRepository;
    private InformationHeartRepository informationHeartRepository;

    @Autowired
    public InformationBoardServiceImplement(    
        UserRepository userRepository,
        InformationBoardRepository informationBoardRepository,
        InformationCommentRepository informationCommentRepository,
        InformationHeartRepository informationHeartRepository
    ){
        this.userRepository = userRepository;
        this.informationBoardRepository = informationBoardRepository;
        this.informationCommentRepository = informationCommentRepository;
        this.informationHeartRepository = informationHeartRepository;
}

    @Override
    public ResponseEntity<ResponseDto> postInformationBoard(String userEmail, PostInformationBoardRequestDto dto) {

        try {
            UserEntity userEntity = userRepository.findByUserEmail(userEmail);
            if(userEntity == null) return CustomResponse.authenticationFailed();
        
            InformationBoardEntity informationBoardEntity = new InformationBoardEntity(userEmail, dto);
            informationBoardRepository.save(informationBoardEntity);
    
        } catch (Exception exception) {
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }

        return CustomResponse.success();

    }

    @Override
    public ResponseEntity<ResponseDto> postInformationComment(String userEmail, PostInformationCommentRequestDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postInformationComment'");
    }

    @Override
    public ResponseEntity<ResponseDto> postInformationHeart(String userEmail, PostInformationHeartRequestDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postInformationHeart'");
    }

    @Override
    public ResponseEntity<ResponseDto> patchInformationBoard(String userEmail, PatchInformationBoardRequestDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'patchInformationBoard'");
    }

    @Override
    public ResponseEntity<ResponseDto> patchInformationComment(String userEmail,
            PatchInformationCommentRequestDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'patchInformationComment'");
    }

    @Override
    public ResponseEntity<ResponseDto> deleteInformationBoard(String userEmail, Integer informationBoardNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteInformationBoard'");
    }

    @Override
    public ResponseEntity<ResponseDto> deleteInformationComment(String userEmail, Integer informationCommentNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteInformationComment'");
    }

    @Override
    public ResponseEntity<ResponseDto> deleteInformationHeart(String userEmail, Integer informationBoardNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteInformationHeart'");
    }

    @Override
    public ResponseEntity<? super GetInformationBoardResponseDto> getInformationBoard(Integer informationBoardNumber) {

        GetInformationBoardResponseDto body = null;

        try {
            if (informationBoardNumber == null) return CustomResponse.validationFailed();

            InformationBoardEntity informationBoardEntity = 
            informationBoardRepository.findByInformationBoardNumber(informationBoardNumber);
            if(informationBoardEntity == null) return CustomResponse.notExistBoardNumber();

            int viewCount = informationBoardEntity.getViewCount();
            informationBoardEntity.setViewCount(++viewCount);
            informationBoardRepository.save(informationBoardEntity);

            String writerEmail = informationBoardEntity.getWriterEmail();
            UserEntity userEntity = userRepository.findByUserEmail(writerEmail);
            List<InformationCommentEntity> informationCommentEntities = 
            informationCommentRepository.findByInformationBoardNumber(informationBoardNumber);
            List<InformationHeartEntity> informationHeartEntities = 
            informationHeartRepository.findAllByInformationBoardNumber(informationBoardNumber);

            body = new GetInformationBoardResponseDto(informationBoardEntity, userEntity, informationCommentEntities, informationHeartEntities);

        } catch (Exception exception){
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }

        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    @Override
    public ResponseEntity<? super GetInformationBoardListResponseDto> getInformationBoardList(String informationSort) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getInformationBoardList'");
    }


    
    
}