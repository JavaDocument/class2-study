package com.practice.jefeel.post.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.jefeel.post.controller.dto.PostSaveRequestDTO;
import com.practice.jefeel.post.controller.dto.PostUpdateRequestDTO;
import com.practice.jefeel.post.domain.entity.Post;
import com.practice.jefeel.post.domain.repository.PostRepository;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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
//        mvc.perform(post("/api/v1/posts").contentType(content)).andExpect(status().isOk());
        //then
        System.out.println("저장성공");
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

//        // when
//        ResultActions result = mockMvc.perform(put(url, savedArticle.getId())
//                .contentType(MediaType.APPLICATION_JSON_VALUE)
//                .content(objectMapper.writeValueAsString(request)));

//// then
        result.andExpect(status().isOk());
        //then
        List<Post> postList = repository.findAll();

        assertEquals(postList.get(0).getTitle(), updatedPost.getTitle());
        assertEquals(postList.get(0).getContent(), updatedPost.getContent());
    }

}