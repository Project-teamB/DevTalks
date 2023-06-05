package com.teamproject.devTalks.dto.request.heart.teacher;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostTeacherHeartRequestDto {
    @NotNull
    private Integer teacherBoardNumber;
}
