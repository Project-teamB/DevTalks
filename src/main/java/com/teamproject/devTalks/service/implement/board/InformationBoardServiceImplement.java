package com.teamproject.devTalks.service.implement.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.teamproject.devTalks.dto.request.board.patchBoard.PatchInformationBoardRequestDto;
import com.teamproject.devTalks.dto.request.board.postBoard.PostInformationBoardRequestDto;
import com.teamproject.devTalks.dto.response.ResponseDto;
import com.teamproject.devTalks.dto.response.board.GetInformationBoardListResponseDto;
import com.teamproject.devTalks.dto.response.board.GetInformationBoardResponseDto;
import com.teamproject.devTalks.repository.board.InformationBoardRepository;
import com.teamproject.devTalks.repository.comment.InformationCommentRepository;
import com.teamproject.devTalks.repository.heart.InformationHeartRepository;
import com.teamproject.devTalks.repository.user.UserRepository;
import com.teamproject.devTalks.service.board.InformationBoardService;

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
    ) {
        this.userRepository = userRepository;
        this.informationBoardRepository = informationBoardRepository;
        this.informationCommentRepository = informationCommentRepository;
        this.informationHeartRepository = informationHeartRepository;
    }

    @Override
    public ResponseEntity<ResponseDto> postInformationBoard(String userEmail, PostInformationBoardRequestDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postInformationBoard'");
    }

    @Override
    public ResponseEntity<? super GetInformationBoardResponseDto> getBoard(Integer informationBoardNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBoard'");
    }

    @Override
    public ResponseEntity<? super GetInformationBoardListResponseDto> getBoardList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBoardList'");
    }

    @Override
    public ResponseEntity<ResponseDto> patchBoard(String userEmail, PatchInformationBoardRequestDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'patchBoard'");
    }

    @Override
    public ResponseEntity<ResponseDto> deleteBoard(String userEmail, Integer boardNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteBoard'");
    }

}
