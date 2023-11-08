package com.practice.jefeel.post.domain.repository;


import com.practice.jefeel.post.domain.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
