package com.practice.jefeel.module.post.domain;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Post extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;


    @Builder
    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }

}
