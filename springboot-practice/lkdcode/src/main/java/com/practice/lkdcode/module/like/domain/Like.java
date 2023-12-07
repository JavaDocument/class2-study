package com.practice.lkdcode.module.like.domain;

import com.practice.lkdcode.global.common.BaseEntity;
import com.practice.lkdcode.module.post.domain.Post;
import com.practice.lkdcode.module.user.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tb_like")
@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class Like extends BaseEntity {
    private enum Status {
        LIKE, NON_LIKE
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Post post;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status = Status.LIKE;

    @Version
    private Long version;

    @Builder
    public Like(User user, Post post) {
        this.user = user;
        this.post = post;
    }

    public void toggleLike() {
        switch (this.status) {
            case LIKE -> this.status = Status.NON_LIKE;
            case NON_LIKE -> this.status = Status.LIKE;
        }
    }

    public boolean isLike() {
        return this.status == Status.LIKE;
    }
}
