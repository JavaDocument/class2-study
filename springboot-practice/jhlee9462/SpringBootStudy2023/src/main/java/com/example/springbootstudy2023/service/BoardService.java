package com.example.springbootstudy2023.service;

import com.example.springbootstudy2023.dto.BoardDTO;
import com.example.springbootstudy2023.dto.SearchDTO;

import java.util.List;

public interface BoardService {

    BoardDTO.CreateResponse createBoard(BoardDTO.CreateRequest boardDTO);

    List<BoardDTO.ListResponse> getBoardList();

    List<BoardDTO.ListResponse> getBoardListByTitleKeyword(SearchDTO.BoardSearchDTO searchDTO);

    BoardDTO.DetailResponse getBoardDetail(Long id);

    BoardDTO.UpdateResponse updateBoard(BoardDTO.UpdateRequest boardDTO);

    void deleteBoard(Long id);
}
