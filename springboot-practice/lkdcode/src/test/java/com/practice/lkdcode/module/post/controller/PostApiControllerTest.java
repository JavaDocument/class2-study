package com.practice.lkdcode.module.post.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.lkdcode.module.post.controller.dto.request.PostRequestDTO;
import com.practice.lkdcode.module.post.domain.Post;
import com.practice.lkdcode.module.post.domain.repository.PostRepository;
import com.practice.lkdcode.module.post.exception.custom.enums.PostErrorCode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Transactional
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class PostApiControllerTest {

    private static final String URL_PREFIX = "/api/posts";

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private PostRepository postRepository;


    @BeforeEach
    void setMockMvc() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .addFilter(new CharacterEncodingFilter("UTF-8", true))
                .alwaysDo(print())
                .build();
        postRepository.deleteAll();
    }

    @Test
    void 게시글_작성_성공_테스트() throws Exception {
        // given
        final String title = "Junit 제목";
        final String content = "Junit 내용";
        PostRequestDTO.Create request = PostRequestDTO.Create.builder()
                .title(title)
                .content(content)
                .build();

        String requestBody = objectMapper.writeValueAsString(request);

        // when
        mockMvc.perform(post(URL_PREFIX)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(requestBody)
        ).andExpect(status().isOk());


        // then
        List<Post> all = postRepository.findAll();
        assertThat(title)
                .isEqualTo(all.get(0).getTitle());
        assertThat(content)
                .isEqualTo(all.get(0).getContent());
    }

    @Test
    void 게시글_작성_실패_테스트() throws Exception {
        // given
        final String errorTitle = "     ";
        final String content = "Junit 내용";
        PostRequestDTO.Create request = PostRequestDTO.Create.builder()
                .title(errorTitle)
                .content(content)
                .build();

        String requestBody = objectMapper.writeValueAsString(request);

        // when
        // then
        MvcResult mvcResult = mockMvc.perform(post(URL_PREFIX)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(requestBody)
                ).andExpect(status().is(HttpStatus.BAD_REQUEST.value()))
                .andReturn();

        assertThat(mvcResult.getResponse().getContentAsString())
                .isEqualTo("제목을 입력해주세요");
    }

    @Test
    void 게시글_전체_조회_성공_테스트() throws Exception {
        // given
        setPostBulkData();

        // when
        MvcResult mvcResult = mockMvc.perform(get(URL_PREFIX)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                ).andExpect(status().isOk())
                .andExpect(jsonPath("$.data[*].id", "10").exists())
                .andExpect(jsonPath("$.data[*].content", "Junit content8").exists())
                .andExpect(jsonPath("$.data[*].content", "Junit content7").exists())
                .andExpect(jsonPath("$.data[*].content", "Junit content5").exists())
                .andExpect(jsonPath("$.data[*].title", "Junit title5").exists())
                .andExpect(jsonPath("$.message", "성공").exists())
                .andDo(print())
                .andReturn();
        // then
        String contentAsString = mvcResult.getResponse().getContentAsString();
        JsonNode jsonNode = objectMapper.readTree(contentAsString);
        String s = jsonNode.at("/data/1/content").asText();

        assertThat(s)
                .isNotEqualTo("테스트 content8");
    }

    @Test
    void 게시글_ID_조회_성공_테스트() throws Exception {
        // given
        final String id = "3";
        final String url = URL_PREFIX + id;
        setPostBulkData();

        // when
        MvcResult mvcResult = mockMvc.perform(get(url)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                ).andExpect(status().isOk())
                .andExpect(jsonPath("$.data.id").exists())
                .andExpect(jsonPath("$.data.title").exists())
                .andExpect(jsonPath("$.data.content").exists())
                .andReturn();

        // then
        String content = mvcResult.getResponse().getContentAsString();
        JsonNode jsonNode = objectMapper.readTree(content);
        String jsonId = jsonNode.at("/data/id").asText();

        assertThat(id)
                .isEqualTo(jsonId);
    }

    @Test
    void 게시글_ID_조회_실패_테스트() throws Exception {
        // given
        final String id = "3000";
        final String url = URL_PREFIX + id;
        setPostBulkData();

        // when
        MvcResult mvcResult = mockMvc.perform(get(url)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                ).andExpect(status().isBadRequest())
                .andReturn();

        // then
        String errorMessage = mvcResult.getResponse().getContentAsString();
        assertThat(errorMessage)
                .isEqualTo(PostErrorCode.NOT_FOUND_POST_BY_ID_ERROR.getMessage() + id);
    }

    @Test
    void 게시글_수정_성공_테스트() throws Exception {
        // given
        final String updateTitle = "수정한 제목";
        final String updateContent = "수정한 내용";

        final String id = "3";
        final String url = URL_PREFIX + id;

        setPostBulkData();

        PostRequestDTO.Update request = PostRequestDTO.Update.builder()
                .title(updateTitle)
                .content(updateContent)
                .build();

        String requestBody = objectMapper.writeValueAsString(request);
        // when

        MvcResult mvcResult = mockMvc.perform(patch(url)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(requestBody)
                ).andExpect(status().isOk())
                .andReturn();

        // then
        String contentAsString = mvcResult.getResponse().getContentAsString();
        JsonNode jsonNode = objectMapper.readTree(contentAsString);
        String updatedTitle = jsonNode.at("/data/title").asText();
        String updatedContent = jsonNode.at("/data/content").asText();

        Assertions.assertThat(updateTitle)
                .isEqualTo(updatedTitle);

        Assertions.assertThat(updateContent)
                .isEqualTo(updatedContent);
    }

    @Test
    void 게시글_수정_실패_테스트() throws Exception {
        // given
        final String errorUpdateTitle = "         ";
        final String updateContent = "수정한 내용";

        final String id = "3";
        final String url = URL_PREFIX + id;

        setPostBulkData();

        PostRequestDTO.Update request = PostRequestDTO.Update.builder()
                .title(errorUpdateTitle)
                .content(updateContent)
                .build();

        String requestBody = objectMapper.writeValueAsString(request);
        // when

        MvcResult mvcResult = mockMvc.perform(patch(url)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(requestBody)
                ).andExpect(status().isBadRequest())
                .andReturn();

        // then
        String contentAsString = mvcResult.getResponse().getContentAsString();
        Assertions.assertThat(contentAsString)
                .isEqualTo("수정할 제목을 입력해주세요");
    }

    private void setPostBulkData() {
        String title = "Junit title";
        String content = "Junit content";

        for (int i = 0; i < 10; i++) {
            postRepository.save(Post.builder()
                    .title(title + i)
                    .content(content + i)
                    .build());
        }
    }

}