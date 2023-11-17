package com.practice.lkdcode.module.user.controller.query;

import com.practice.lkdcode.global.config.security.CustomUserDetails;
import com.practice.lkdcode.module.user.controller.dto.UserDTO;
import com.practice.lkdcode.module.user.service.UserQueryUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserQueryApiController {
    private final UserQueryUsecase userQueryUsecase;

    @GetMapping("/information")
    public UserDTO.UserInformationDTO getUserInformation(
            @AuthenticationPrincipal CustomUserDetails customUserDetails
    ) {
        return userQueryUsecase.retrieveUserInformation(customUserDetails.getId());
    }
}
