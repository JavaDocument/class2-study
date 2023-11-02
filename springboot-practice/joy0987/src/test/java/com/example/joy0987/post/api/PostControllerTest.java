package com.example.joy0987.post.api;

import com.example.joy0987.post.dto.PostUpdateRequestDTO;
import com.example.joy0987.post.dto.PostRequestDTO;
import com.example.joy0987.post.entity.Post;
import com.example.joy0987.post.repository.PostRepository;
import com.example.joy0987.post.service.PostService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Rollback(true)
class PostControllerTest {

    @Autowired
    private PostController postController;

    @Autowired
    private PostService postService;

    @Autowired
    private PostRepository postRepository;

    @Test
    @DisplayName("제목과 본문이 비어있지 않을 시 게시글 입력에 성공해야하고 http status가 200이어야한다.")
    void getPostSuccess() {
        PostRequestDTO requestDTO = new PostRequestDTO(
                "title"
                , "content"
        );

        ResponseEntity<?> responseEntity = postController.insertPost(requestDTO);
        assertNotNull(responseEntity);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
    }

    @Test
    @DisplayName("제목과 본문 중 하나라도 비어있을 시 http status가 400이어야한다.")
    void insertPostFail() {
        String content = null;
        PostRequestDTO requestDTO = new PostRequestDTO(
                "title"
                , content
        );

        ResponseEntity<?> responseEntity = postController.insertPost(requestDTO);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.BAD_REQUEST);
    }

    @Test
    @DisplayName("게시글이 한 건이라도 존재하는 경우 http status가 200이어야 하고 응답객체의 바디가 Null이 아니어야한다.")
    void getPostListSuccess() {
        ResponseEntity<?> responseEntity = postController.getPostList();
        assertNotNull(responseEntity.getBody());
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
    }

    @Test
    @DisplayName("존재하지 않는 게시글 조회 시 http status가 400이어야 한다.")
    void getPostFail() {
        int postId = 100;
        ResponseEntity<?> responseEntity = postController.getPost(postId);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.BAD_REQUEST);
    }

}