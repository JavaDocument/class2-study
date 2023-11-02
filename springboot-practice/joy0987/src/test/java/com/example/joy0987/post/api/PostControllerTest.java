package com.example.joy0987.post.api;

import com.example.joy0987.post.dto.PostRequestDTO;
import com.example.joy0987.post.entity.Post;
import com.example.joy0987.post.repository.PostRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;
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

    @Test
    @DisplayName("제목과 본문이 비어있지 않을 시 게시글 입력에 성공해야한다.")
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
    @DisplayName("제목과 본문 중 하나라도 비어있을 시 게시글 생성에 실패하고 NullPointException이 발생해야한다.")
    void getPostFail() {
        String content = null;

        assertThrows(NullPointerException.class, () -> {
            new PostRequestDTO(
                    "title"
                    , content
            );
        });
    }
}