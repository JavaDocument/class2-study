package com.example.springbootstudy2023.board.repository;

import com.example.springbootstudy2023.board.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

    Page<Board> findBoardsByTitleContaining(Pageable pageable, String keyword);

}
