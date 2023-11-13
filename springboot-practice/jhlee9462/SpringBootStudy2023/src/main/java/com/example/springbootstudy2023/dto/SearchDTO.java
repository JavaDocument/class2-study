package com.example.springbootstudy2023.dto;

public interface SearchDTO {

    record BoardSearchDTO (
            String keyword
    ) implements SearchDTO {
        public static BoardSearchDTO of(String keyword) {
            return new BoardSearchDTO(keyword);
        }
    }

}
