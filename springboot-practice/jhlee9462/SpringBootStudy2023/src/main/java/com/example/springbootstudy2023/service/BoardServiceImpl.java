package com.example.springbootstudy2023.service;

import com.example.springbootstudy2023.dto.BoardDTO;
import com.example.springbootstudy2023.dto.SearchDTO;
import com.example.springbootstudy2023.entity.Board;
import com.example.springbootstudy2023.exception.ValidateException;
import com.example.springbootstudy2023.repository.BoardRepository;
import com.example.springbootstudy2023.utils.SearchValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    private final SearchValidator searchValidator;

    @Override
    public BoardDTO.CreateResponse createBoard(BoardDTO.CreateRequest boardDTO) {
        return BoardDTO.CreateResponse
                .of(boardRepository.save(Board.of(boardDTO)));
    }

    @Override
    public List<BoardDTO.ListResponse> getBoardList() {
        return boardRepository.findAll(PageRequest.of(0,
                        100,
                        Sort.by(Sort.Direction.DESC, "createTime"))).stream()
                .map(BoardDTO.ListResponse::of)
                .toList();
    }

    @Override
    public List<BoardDTO.ListResponse> getBoardListByTitleKeyword(SearchDTO.BoardSearchDTO searchDTO) throws ValidateException {
        searchValidator.validate(searchDTO);
        return boardRepository.findBoardsByTitleContaining(PageRequest.of(0,
                                100,
                                Sort.by(Sort.Direction.DESC, "createTime")),
                        searchDTO.keyword()).stream()
                .map(BoardDTO.ListResponse::of)
                .toList();
    }

    @Override
    public BoardDTO.DetailResponse getBoardDetail(Long id) throws NoSuchElementException {
        return BoardDTO.DetailResponse.of(boardRepository.findById(id).orElseThrow());
    }

    @Override
    public BoardDTO.UpdateResponse updateBoard(BoardDTO.UpdateRequest boardDTO) {
        return BoardDTO.UpdateResponse.of(boardRepository.save(Board.of(boardDTO)));
    }

    // JPA에서 삭제는 void를 리턴한다. 삭제의 결과는 굳이 필요하지 않다고 생각한듯.
    // 없는 id라서 삭제하지 못한 경우도 삭제한 것과 같은 결과이기 때문
    @Override
    public void deleteBoard(Long id) {
        boardRepository.findById(id).orElseThrow(NoSuchElementException::new);
        boardRepository.deleteById(id);
    }
}
