package com.example.springbootstudy2023.board.api;

import com.example.springbootstudy2023.board.dto.BoardDTO;
import com.example.springbootstudy2023.global.dto.SearchDTO;
import com.example.springbootstudy2023.global.exception.ValidateException;
import com.example.springbootstudy2023.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/boards")
@Slf4j
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    public ResponseEntity<BoardDTO.CreateResponse> createBoard(@RequestBody @Valid BoardDTO.CreateRequest requestDto) {
        return ResponseEntity.ok(boardService.createBoard(requestDto));
    }

    @GetMapping
    public ResponseEntity<List<BoardDTO.ListResponse>> getBoardList() {
        return ResponseEntity.ok(boardService.getBoardList());
    }

    // PathVariable에 바로 NotBlank를 사용할 수 없음...
    @GetMapping("/title/{keyword}")
    public ResponseEntity<?> getBoardListByTitleKeyword(@PathVariable String keyword) {
        return ResponseEntity.ok(boardService.getBoardListByTitleKeyword(keyword));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBoardDetail(@PathVariable Long id) {
        return ResponseEntity.ok(boardService.getBoardDetail(id));
    }

    @PutMapping
    public ResponseEntity<BoardDTO.UpdateResponse> updateBoard(@RequestBody BoardDTO.UpdateRequest requestDto) {
        return ResponseEntity.ok(boardService.updateBoard(requestDto));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBoard(@PathVariable Long id) {
        boardService.deleteBoard(id);
        return ResponseEntity.ok("삭제되었습니다.");
    }

}
