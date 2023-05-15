package com.teamproject.devTalks.service.implement.board;

import com.teamproject.devTalks.common.util.CustomResponse;
import com.teamproject.devTalks.dto.request.board.qna.PatchQnaBoardRequestDto;
import com.teamproject.devTalks.dto.request.board.qna.PostQnaBoardRequestDto;
import com.teamproject.devTalks.dto.request.comment.qna.PatchQnaCommentRequestDto;
import com.teamproject.devTalks.dto.request.comment.qna.PostQnaCommentRequestDto;
import com.teamproject.devTalks.dto.request.heart.qna.PostQnaHeartRequestDto;
import com.teamproject.devTalks.dto.response.ResponseDto;
import com.teamproject.devTalks.dto.response.board.qna.GetQnaBoardListResponseDto;
import com.teamproject.devTalks.dto.response.board.qna.GetQnaBoardResponseDto;
import com.teamproject.devTalks.entity.board.QnaBoardEntity;
import com.teamproject.devTalks.entity.comment.QnaCommentEntity;
import com.teamproject.devTalks.entity.hashTag.QnaBoardHashTagEntity;
import com.teamproject.devTalks.entity.heart.QnaHeartEntity;
import com.teamproject.devTalks.entity.resultSet.QnaBoardListResultSet;
import com.teamproject.devTalks.entity.user.UserEntity;
import com.teamproject.devTalks.repository.board.QnaBoardRepository;
import com.teamproject.devTalks.repository.comment.QnaCommentRepository;
import com.teamproject.devTalks.repository.hashTag.QnaBoardHashTagRepository;
import com.teamproject.devTalks.repository.heart.QnaHeartRepository;
import com.teamproject.devTalks.repository.user.UserRepository;
import com.teamproject.devTalks.service.board.QnaBoardService;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service // component로 쓰려고
@RequiredArgsConstructor
public class QnaBoardServiceImplement implements QnaBoardService {

    private final UserRepository userRepository;
    private final QnaBoardRepository qnaBoardRepository;
    private final QnaCommentRepository qnaCommentRepository;
    private final QnaBoardHashTagRepository qnaBoardHashTagRepository;
    private final QnaHeartRepository qnaHeartRepository;

    @Override
    public ResponseEntity<? super GetQnaBoardListResponseDto> getQnaBoardList(String qnaSort) {

        GetQnaBoardListResponseDto body = null;
        try {

            List<QnaBoardListResultSet> resultSets = qnaBoardRepository.getList();
            body = new GetQnaBoardListResponseDto(resultSets);

        } catch (Exception exception) {
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }
        return CustomResponse.success();
    }

    // 이거
    @Override
    public ResponseEntity<? super GetQnaBoardResponseDto> getQnaBoard(int qnaBoardNumber) {

        GetQnaBoardResponseDto body = null;
        try {
            // 존재하지 않는 게시물 반환
            QnaBoardEntity qnaBoardEntity = qnaBoardRepository.findByQnaBoardNumber(qnaBoardNumber);
            if (qnaBoardEntity == null)
                return CustomResponse.notExistBoardNumber();

            int viewCount = qnaBoardEntity.getViewCount();
            qnaBoardEntity.setViewCount(++viewCount);
            qnaBoardRepository.save(qnaBoardEntity);

            String qnaBoardWriterEmail = qnaBoardEntity.getWriterEmail();
            UserEntity userEntity = userRepository.findByUserEmail(qnaBoardWriterEmail);

            // 모르겠다

        } catch (Exception exception) {
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }
        return CustomResponse.success();

    }

    @Override
    public ResponseEntity<ResponseDto> postQnaBoard(String userEmail, PostQnaBoardRequestDto dto) {

        List<String> hashtagList = dto.getHashtag();
        List<QnaBoardHashTagEntity> qnaHashtagList = new ArrayList<>();

        try {
            // 존재하지 않는 유저(이메일)
            UserEntity userEntity = userRepository.findByUserEmail(userEmail);
            if (userEntity == null)
                return CustomResponse.noExistUser();

            // Date now = new Date();
            // SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

            // String writerProfileImageUrl = userEntity.getUserProfileImageUrl();
            // String writerNickname = userEntity.getUserNickname();
            // String writerDatetime = dateFormat.format(now);
            // String qnaTitle = dto.getQnaTitle();
            // String qnaContent = dto.getQnaContent();
            // String qnaBoardImageUrl = dto.getQnaBoardImageUrl();
            // QnaBoardEntity qnaBoardEntity = new QnaBoardEntity(0, writerProfileImageUrl,
            // writerNickname, writerDatetime, qnaTitle, qnaContent, qnaBoardImageUrl);

            QnaBoardEntity qnaBoardEntity = new QnaBoardEntity(userEntity, dto);
            qnaBoardRepository.save(qnaBoardEntity);

            for (String hashTag : hashtagList) {
                QnaBoardHashTagEntity qnaBoardHashTagEntity = new QnaBoardHashTagEntity(hashTag,
                        qnaBoardEntity.getQnaBoardNumber());

                // qnaBoardHashTagRepository.save(qnaBoardHashTagEntity);

                qnaHashtagList.add(qnaBoardHashTagEntity); // 하나의 qnaHasgEntity라는 객체를 담을 리스트에 담은거
            }

            qnaBoardHashTagRepository.saveAll(qnaHashtagList);

            // 데이터베이스오류
        } catch (Exception exception) {
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }

        // return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("SU",
        // "Success"));
        return CustomResponse.success();
    }

    @Override
    public ResponseEntity<ResponseDto> postQnaComment(String userEmail, PostQnaCommentRequestDto dto) {
        try {
            // 존재하지 않는 유저(이메일)
            UserEntity userEntity = userRepository.findByUserEmail(userEmail);
            if (userEntity == null)
                return CustomResponse.noExistUser();

            // 존재하지 않는 게시물(게시물번호)
            QnaBoardEntity qnaBoardEntity = qnaBoardRepository.findByQnaBoardNumber(0);
            if (qnaBoardEntity == null)
                return CustomResponse.notExistBoardNumber();

            QnaCommentEntity qnaCommentEntity = new QnaCommentEntity(userEntity, qnaBoardEntity, dto);
            qnaCommentRepository.save(qnaCommentEntity);

            // 데이터베이스 오류
        } catch (Exception exception) {
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }

        return CustomResponse.success();

    }

    @Override
    public ResponseEntity<ResponseDto> postQnaHeart(String userEmail, PostQnaHeartRequestDto dto) {
        try {
            // 존재하지 않는 유저(이메일)
            UserEntity userEntity = userRepository.findByUserEmail(userEmail);
            if (userEntity == null)
                return CustomResponse.noExistUser();
            // 존재하지 않는 게시물(게시물번호)
            QnaBoardEntity qnaBoardEntity = qnaBoardRepository.findByQnaBoardNumber(0);
            if (qnaBoardEntity == null)
                return CustomResponse.notExistBoardNumber();

            QnaHeartEntity qnaHeartEntity = new QnaHeartEntity(userEntity, qnaBoardEntity);
            qnaHeartRepository.save(qnaHeartEntity);

            // 데이터베이스 오류
        } catch (Exception exception) {
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }

        return CustomResponse.success();
    }

    @Override
    public ResponseEntity<ResponseDto> patchQnaBoard(String userEmail, PatchQnaBoardRequestDto dto) {
        try {
            // 존재하지 않는 유저(이메일)
            UserEntity userEntity = userRepository.findByUserEmail(userEmail);
            if (userEntity == null)
                return CustomResponse.noExistUser();
            // 존재하지 않는 게시물(게시물번호)
            QnaBoardEntity qnaBoardEntity = qnaBoardRepository.findByQnaBoardNumber(0);
            if (qnaBoardEntity == null)
                return CustomResponse.notExistBoardNumber();

            QnaBoardEntity qnaBoardEntityPathch = new QnaBoardEntity(userEntity, dto);
            qnaBoardRepository.save(qnaBoardEntityPathch);

            // 데이터베이스 오류
        } catch (Exception exception) {
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }
        return CustomResponse.success();
    }

    @Override
    public ResponseEntity<ResponseDto> patchQnaComment(String userEmail, PatchQnaCommentRequestDto dto) {
        try {
            // 존재하지 않는 유저(이메일)
            UserEntity userEntity = userRepository.findByUserEmail(userEmail);
            if (userEntity == null)
                return CustomResponse.noExistUser();
            // 존재하지 않는 게시물(게시물번호)
            QnaBoardEntity qnaBoardEntity = qnaBoardRepository.findByQnaBoardNumber(0);
            if (qnaBoardEntity == null)
                return CustomResponse.notExistBoardNumber();
            // 존재하지 않는 댓글(댓글번호)
            QnaCommentEntity qnaCommentEntity = qnaCommentRepository.findByQnaCommentNumber(0);
            if (qnaCommentEntity == null)
                return CustomResponse.notExistCommentNumber();

            QnaCommentEntity qnaCommentEntityPatch = new QnaCommentEntity(userEntity, qnaBoardEntity, dto);
            qnaCommentRepository.save(qnaCommentEntityPatch);

            // 데이터베이스 오류
        } catch (Exception exception) {
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }
        return CustomResponse.success();

    }

    @Override
    public ResponseEntity<ResponseDto> deleteQnaBoard(String userEmail, int qnaBoardNumber) {

        try {
            // 존재하지 않는 유저(이메일)
            boolean existUser = userRepository.existsByUserEmail(userEmail);
            if (!existUser)
                return CustomResponse.noExistUser();
            // 존재하지 않는 게시물(게시물 번호)
            QnaBoardEntity qnaBoardEntity = qnaBoardRepository.findByQnaBoardNumber(qnaBoardNumber);
            if (qnaBoardEntity == null)
                return CustomResponse.notExistBoardNumber();

            qnaCommentRepository.deleteByQnaBoardNumber(qnaBoardNumber);
            qnaHeartRepository.deleteByQnaBoardNumber(qnaBoardNumber);
            qnaBoardHashTagRepository.deleteByQnaBoardNumber(qnaBoardNumber);
            qnaBoardRepository.delete(qnaBoardEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }
        return CustomResponse.success();
    }

    @Override
    public ResponseEntity<ResponseDto> deleteQnaComment(String userEmail, int qnaCommentNumber) {
        try {
            // 존재하지 않는 유저(이메일)
            boolean existUser = userRepository.existsByUserEmail(userEmail);
            if (!existUser)
                return CustomResponse.noExistUser();

            qnaCommentRepository.deleteByQnaCommentNumber(qnaCommentNumber);

        } catch (Exception exception) {
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }
        return CustomResponse.success();
    }

    @Override
    public ResponseEntity<ResponseDto> deleteQnaHeart(String userEmail, int qnaBoardNumber) {
        try {

            // 존재하지 않는 유저(이메일)
            UserEntity userEntity = userRepository.findByUserEmail(userEmail);
            if (userEntity == null)
                return CustomResponse.noExistUser();
            int userNumber = userEntity.getUserNumber();
            qnaHeartRepository.deleteByUserNumberAndQnaBoardNumber(userNumber, qnaBoardNumber);

        } catch (Exception exception) {
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }
        return CustomResponse.success();
    }

}
