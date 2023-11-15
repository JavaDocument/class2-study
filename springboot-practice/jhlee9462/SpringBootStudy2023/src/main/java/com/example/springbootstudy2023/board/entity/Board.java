package com.example.springbootstudy2023.board.entity;

import com.example.springbootstudy2023.board.dto.BoardDTO;
import com.example.springbootstudy2023.global.entity.CommonEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

// JPA 의 Entity는 기본 생성자만 있으면 된다. setter는 필요없다.
@Entity
@Getter
@NoArgsConstructor
@Table(name = "board")
public class Board extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;

    // TODO: 하나의 생성자에서 instanc of 연산자로 분기 나누는 것으로 바꾸기

    private Board(BoardDTO.CreateRequest dto) {
        this.title = dto.title();
        this.content = dto.content();
    }

    private Board(BoardDTO.UpdateRequest dto) {
        this.id = dto.id();
        this.title = dto.title();
        this.content = dto.content();
    }

    // 생성자를 오버로딩해서 여러개 만드는 것이 좋을까?
    // 아니면 하나의 생성자에서 instance of 연산자를 사용해서 조건문으로 분기를 나누는 것이 좋을까?
    public static Board of(BoardDTO.CreateRequest dto) {
        return new Board(dto);
    }

    public static Board of(BoardDTO.UpdateRequest dto) {
        return new Board(dto);
    }

}
