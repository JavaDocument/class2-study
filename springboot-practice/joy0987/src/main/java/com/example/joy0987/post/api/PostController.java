package com.example.joy0987.post.api;

import com.example.joy0987.post.dto.PostRequestDTO;
import com.example.joy0987.post.dto.PostResponseDTO;
import com.example.joy0987.post.entity.Post;
import com.example.joy0987.post.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @GetMapping
    public ResponseEntity<?> getPostList() {
        log.info("[getPostList]");

        try {
            List<PostResponseDTO> responseDTO = postService.getPostList();
            return ResponseEntity.ok(responseDTO);
        } catch (RuntimeException e) {
            throw new RuntimeException("RuntimeException");
        }
    }

    @GetMapping("/{postId}")
    public ResponseEntity<?> getPost(
            @PathVariable("postId") int postId
    ) {
        log.info("[getPost] postId : {}", postId);

//        try {
//            PostResponseDTO responseDTO = postService.getPost(postId);
//        } catch (NullPointerException e) {
//            throw new NullPointerException("존재하지않는 게시글");
//        }
        return null;
    }

    @PostMapping
    public ResponseEntity<?> insertPost(
        @RequestBody PostRequestDTO requestDTO
    ) {
        log.info("[insertPost] postTitle : {}", requestDTO.postTitle());

        try {
            Post saved = postService.insertPost(requestDTO);
            return ResponseEntity.ok(saved);
        } catch (NullPointerException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (RuntimeException e) {
            throw new RuntimeException("runtimeException");
        }
    }
}
