package com.practice.lkdcode.module.post.controller.query;

import com.practice.lkdcode.module.post.controller.dto.response.PostResponseDTO;
import com.practice.lkdcode.module.post.controller.response.PostResponse;
import com.practice.lkdcode.module.post.service.query.PostQueryUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostQueryApi {
    private final PostQueryUsecase postQueryUsecase;

    @GetMapping("/{id}")
    public PostResponse<PostResponseDTO.Get> getPostById(
            @PathVariable(name = "id") final Long id
    ) {
        PostResponseDTO.Get response = postQueryUsecase.retrieveFindById(id);
        return PostResponse.ok(response);
    }

    @GetMapping
    public PostResponse<List<PostResponseDTO.Get>> getAllPosts(
            @PageableDefault(size = 3, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable
    ) {
        List<PostResponseDTO.Get> responseList = postQueryUsecase.retrieveFindAll(pageable);
        return PostResponse.ok(responseList);
    }

    @GetMapping("/search/{keyword}")
    public PostResponse<List<PostResponseDTO.Get>> getPostsByKeyword(
            @PathVariable(name = "keyword") String keyword,
            @PageableDefault(size = 3, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable
    ) {
        List<PostResponseDTO.Get> responseList = postQueryUsecase.retrieveFindByTitleContaining(keyword, pageable);
        return PostResponse.ok(responseList);
    }

}
