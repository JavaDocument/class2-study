package com.practice.lkdcode.module.reply.domain;

import com.practice.lkdcode.global.common.BaseEntity;
import com.practice.lkdcode.module.post.domain.Post;
import com.practice.lkdcode.module.user.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Table(name = "tb_reply")
public class Reply extends BaseEntity {
    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Reply(String content, Post post, User user) {
        this.content = content;
        this.post = post;
        this.user = user;
    }
}
