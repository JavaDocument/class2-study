package com.example.springbootstudy2023.api;

import com.example.springbootstudy2023.dto.BoardDTO;
import com.example.springbootstudy2023.dto.SearchDTO;
import com.example.springbootstudy2023.exception.ValidateException;
import com.example.springbootstudy2023.service.BoardService;
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

    // TODO : ExceptionHandler 사용해서 예외처리 따로해주기

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
        try {
            return ResponseEntity.ok(boardService.getBoardListByTitleKeyword(SearchDTO.BoardSearchDTO.of(keyword)));
        } catch (ValidateException e) {
            return ResponseEntity.ok(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBoardDetail(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(boardService.getBoardDetail(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.ok("존재하지 않는 게시글입니다.");
        }
    }

    @PutMapping
    public ResponseEntity<BoardDTO.UpdateResponse> updateBoard(@RequestBody BoardDTO.UpdateRequest requestDto) {
        return ResponseEntity.ok(boardService.updateBoard(requestDto));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBoard(@PathVariable Long id) {
        try {
            boardService.deleteBoard(id);
            return ResponseEntity.ok("삭제되었습니다.");
        } catch (NoSuchElementException e) {
            return ResponseEntity.ok("존재하지 않는 게시글입니다.");
        }
    }

}
