package com.practice.jefeel.post.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.jefeel.module.post.controller.PostController;
import com.practice.jefeel.module.post.controller.dto.PostSaveRequestDTO;
import com.practice.jefeel.module.post.controller.dto.PostUpdateRequestDTO;
import com.practice.jefeel.module.post.domain.Post;
import com.practice.jefeel.module.post.domain.repository.PostRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class PostControllerTest {

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    private PostController controller;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private PostRepository repository;

    @AfterEach
    public void cleanUp() {
        repository.deleteAll();
    }

    @Test
    @DisplayName("controller save test")
    void controllerSaveTest() throws Exception {
        //given
        String title = "저장테스트 제목";
        String content = "저장테스트 본문";
        PostSaveRequestDTO dto = PostSaveRequestDTO.builder()
                .title(title)
                .content(content)
                .build();

        //when
        mvc.perform(post("/api/v1/posts")
                        .contentType("application/json")
                        .content(new ObjectMapper().writeValueAsString(dto))
                )
                .andExpect(status().isOk());
        //then
        System.out.println("저장성공");
    }

    @Test
    @DisplayName("controller find by id test")
    void controllerFindByIdTest() throws Exception {
        //given
        Long id = 1L;
        Post post = repository.save(Post.builder()
                .title("테스트 제목")
                .content("테스트 내용")
                .build());

        //when
        ResultActions resultActions = mvc.perform(get("/api/v1/posts/"+id)
                .accept(MediaType.APPLICATION_JSON_VALUE));

        //then
        resultActions.andExpect(status().isOk());
        assertEquals(id, post.getId());
        System.out.println(post.getCreatedDate());
    }

    @Test
    @DisplayName("controller update test")
    void controllerUpdateTest() throws Exception {
        //given
        Post savedPost = repository.save(Post.builder()
                .title("테스트 제목")
                .content("테스트 내용")
                .build());

        Long id = savedPost.getId();
        String updateTitle = "업데이트 제목";
        String updateContent = "업데이트 내용";

        PostUpdateRequestDTO updatedPost = PostUpdateRequestDTO.builder()
                .title(updateTitle)
                .content(updateContent)
                .build();
        // body에 담는 작업


        //when
        ResultActions result = mvc.perform(put("/api/v1/posts/" + id)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(updatedPost)));

        result.andExpect(status().isOk());

        //then
        List<Post> postList = repository.findAll();

        assertEquals(postList.get(0).getTitle(), updatedPost.getTitle());
        assertEquals(postList.get(0).getContent(), updatedPost.getContent());
    }

    // 실패 테스트 코드도 고려

    @Test
    @DisplayName("controller delete test")
    void controllerDeleteTest() throws Exception {
        //given
        Post post = repository.save(Post.builder()
                .title("테스트 제목1")
                .content("테스트 내용1")
                .build());

        Long id = post.getId();

        //when
        ResultActions result = mvc.perform(delete("/api/v1/posts/" + id)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE));

        result.andExpect(status().isOk());

        //then
        List<Post> deletedPost = repository.findAll();
        assertThat(deletedPost).isEmpty();
    }

}