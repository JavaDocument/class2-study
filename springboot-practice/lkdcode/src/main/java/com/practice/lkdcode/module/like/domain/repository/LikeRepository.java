package com.practice.lkdcode.module.like.domain.repository;

import com.practice.lkdcode.module.like.domain.Like;
import com.practice.lkdcode.module.post.domain.Post;
import com.practice.lkdcode.module.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    @Lock(value = LockModeType.WRITE)
    @Query("SELECT l " +
            "FROM Like l " +
            "WHERE l.user = :user AND l.post = :post")
    Like findByUserAndPostForUpdate(@Param("user") User user, @Param("post") Post post);
}
