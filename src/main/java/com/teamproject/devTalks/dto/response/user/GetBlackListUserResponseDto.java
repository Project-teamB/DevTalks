package com.teamproject.devTalks.dto.response.user;

import com.teamproject.devTalks.dto.response.ResponseDto;
import com.teamproject.devTalks.entity.user.BlackListEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GetBlackListUserResponseDto extends ResponseDto {

    private int userNumber;
    private String reason;
    private String createdAt;

    public GetBlackListUserResponseDto(BlackListEntity blackListEntity) {
        super("SU","Success");
        this.userNumber = blackListEntity.getUserNumber();
        this.reason = blackListEntity.getReason();
        this.createdAt = blackListEntity.getCreatedAt();
    }
}
