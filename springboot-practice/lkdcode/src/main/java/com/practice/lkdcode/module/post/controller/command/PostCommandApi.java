package com.practice.lkdcode.module.post.controller.command;

import com.practice.lkdcode.global.config.security.CustomUserDetails;
import com.practice.lkdcode.module.post.controller.dto.request.PostRequestDTO;
import com.practice.lkdcode.module.post.controller.dto.response.PostResponseDTO;
import com.practice.lkdcode.module.post.controller.response.PostResponse;
import com.practice.lkdcode.module.post.service.command.PostCommandUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
@Validated
public class PostCommandApi {

    private final PostCommandUsecase postCommandUsecase;

    @PostMapping
    public PostResponse<PostResponseDTO.Create> getCreatePost(
            @AuthenticationPrincipal CustomUserDetails customUserDetails,
            @Valid @RequestBody final PostRequestDTO.Create request
    ) {
        PostResponseDTO.Create response = postCommandUsecase.executeSave(request, customUserDetails);
        return PostResponse.ok(response);
    }

    @DeleteMapping("/{id}")
    public PostResponse<PostResponseDTO.Delete> getDeletePost(
            @AuthenticationPrincipal CustomUserDetails customUserDetails,
            @PathVariable(name = "id") @Min(1) /*@NotBlank Long 에는 적용 불가*/ final Long id
    ) {
        PostResponseDTO.Delete response = postCommandUsecase.executeDelete(id, customUserDetails);
        return PostResponse.ok(response);
    }

    @PatchMapping("/{id}")
    public PostResponse<PostResponseDTO.Update> getUpdatePost(
            @AuthenticationPrincipal CustomUserDetails customUserDetails,
            @PathVariable(name = "id") @Min(1) /*@NotBlank Long 에는 적용 불가*/ final Long id, // @Min, @NotBlank
            @Valid @RequestBody final PostRequestDTO.Update request
    ) {
        PostResponseDTO.Update response = postCommandUsecase.executeUpdate(id, request, customUserDetails);
        return PostResponse.ok(response);
    }
}
