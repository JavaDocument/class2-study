package com.example.joy0987.post.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POST_ID")
    private int postId;

    @Column(name = "POST_TITLE", nullable = false, length = 300)
    private String postTitle;

    @Column(name = "POST_CONTENT", nullable = false, length = 10)
    private String postContent;

    public void update(String title, String content) {
        this.postTitle = title;
        this.postContent = content;
    }

}
