package com.teamproject.devTalks.controller.user;

import com.teamproject.devTalks.dto.request.user.PostBlackListRequestDto;
import com.teamproject.devTalks.dto.response.ResponseDto;
import com.teamproject.devTalks.security.AdminPrinciple;
import com.teamproject.devTalks.service.user.BlackListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/admin/blackList")
@RequiredArgsConstructor
public class BlackListController {

    private final BlackListService blackListService;

    @PostMapping("")
    public ResponseEntity<ResponseDto> postBlackList(
            @Valid @RequestBody PostBlackListRequestDto dto,
            @AuthenticationPrincipal AdminPrinciple adminPrinciple
    ){
        String adminEmail = adminPrinciple.getAdminEmail();
        ResponseEntity<ResponseDto> response
                = blackListService.postBlackList(adminEmail,dto);

        return response;

    }





}
