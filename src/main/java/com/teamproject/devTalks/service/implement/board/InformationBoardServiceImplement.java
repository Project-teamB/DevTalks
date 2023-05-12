package com.teamproject.devTalks.service.implement.board;

import java.nio.file.attribute.UserPrincipal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.teamproject.devTalks.dto.response.ResponseDto;
import com.teamproject.devTalks.repository.board.InformationBoardRepository;
import com.teamproject.devTalks.repository.comment.InformationCommentRepository;
import com.teamproject.devTalks.repository.heart.InformationHeartRepository;
import com.teamproject.devTalks.repository.user.UserRepository;
import com.teamproject.devTalks.dto.response.board.information.GetInformationBoardListResponseDto;
import com.teamproject.devTalks.dto.response.board.information.GetInformationBoardResponseDto;
import com.teamproject.devTalks.service.board.InformationBoardService;
import com.teamproject.devTalks.dto.heart.information.PostInformationHeartRequestDto;
import com.teamproject.devTalks.dto.request.board.information.PatchInformationBoardRequestDto;
import com.teamproject.devTalks.dto.request.board.information.PostInformationBoardRequestDto;
import com.teamproject.devTalks.dto.request.comment.information.PatchInformationCommentRequestDto;
import com.teamproject.devTalks.dto.request.comment.information.PostInformationCommentRequestDto;

@Service
public class InformationBoardServiceImplement implements InformationBoardService {
    
    private UserRepository userRepository;
    private InformationBoardRepository informationBoardRepository;
    private InformationCommentRepository informationCommentRepository;
    private InformationHeartRepository informationHeartRepository;
    @Override
    public ResponseEntity<ResponseDto> postInformationBoard(UserPrincipal userPrincipal,
            PostInformationBoardRequestDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postInformationBoard'");
    }
    @Override
    public ResponseEntity<ResponseDto> postInformationComment(UserPrincipal userPrincipal,
            PostInformationCommentRequestDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postInformationComment'");
    }
    @Override
    public ResponseEntity<ResponseDto> postInformationHeart(UserPrincipal userPrincipal,
            PostInformationHeartRequestDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postInformationHeart'");
    }
    @Override
    public ResponseEntity<ResponseDto> patchInformationBoard(UserPrincipal userPrincipal,
            PatchInformationBoardRequestDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'patchInformationBoard'");
    }
    @Override
    public ResponseEntity<ResponseDto> patchInformationComment(UserPrincipal userPrincipal,
            PatchInformationCommentRequestDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'patchInformationComment'");
    }
    @Override
    public ResponseEntity<ResponseDto> deleteInformationBoard(UserPrincipal userPrincipal,
            Integer informationBoardNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteInformationBoard'");
    }
    @Override
    public ResponseEntity<ResponseDto> deleteInformationComment(UserPrincipal userPrincipal,
            Integer informationCommentNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteInformationComment'");
    }
    @Override
    public ResponseEntity<ResponseDto> deleteInformationHeart() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteInformationHeart'");
    }
    @Override
    public ResponseEntity<? super GetInformationBoardResponseDto> getInformationBoard(Integer informationBoardNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getInformationBoard'");
    }
    @Override
    public ResponseEntity<? super GetInformationBoardListResponseDto> getInformationBoardList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getInformationBoardList'");
    }
    
}