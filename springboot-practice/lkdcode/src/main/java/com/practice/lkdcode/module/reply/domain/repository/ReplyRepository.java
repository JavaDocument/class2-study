package com.practice.lkdcode.module.reply.domain.repository;

import com.practice.lkdcode.module.reply.domain.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {
}
