package com.practice.lkdcode.module.reply.domain.repository;

import com.practice.lkdcode.module.reply.domain.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {
    List<Reply> findFirst3ByPostId(Long postId);
}
