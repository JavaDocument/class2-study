package com.practice.jefeel.post.domain.repository;


import com.practice.jefeel.post.domain.entity.Post;
import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class PostRepositoryTest {

    @Autowired
    PostRepository repository;

    @AfterEach
    public void cleanUp() {
        repository.deleteAll();
    }

    @Test
    @DisplayName("repository find test")
    void repoFindTest() {
        //given
        String title = "조회제목";
        String content = "조회본문";

        repository.save(Post.builder()
                .title(title)
                .content(content)
                .build());
        //when
        List<Post> posts = repository.findAll();

        //then
        Post post = posts.get(0);
        assertEquals(post.getTitle(), title);
        System.out.println("assert title test : " + title);
        assertEquals(post.getContent(), content);
        System.out.println("assert content test : " + content);
    }
}