package com.practice.lkdcode.module.post.domain;

import com.practice.lkdcode.global.common.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tb_post")
public class Post extends BaseEntity {
    @Column(name = "title", nullable = false, length = 100)
    private String title;
    @Column(columnDefinition = "TEXT", name = "content", nullable = false, length = 1_000)
    private String content;

    @Builder
    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
