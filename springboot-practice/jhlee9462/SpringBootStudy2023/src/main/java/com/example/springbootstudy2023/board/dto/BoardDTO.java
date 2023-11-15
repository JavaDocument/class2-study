package com.example.springbootstudy2023.board.dto;

import com.example.springbootstudy2023.board.entity.Board;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public interface BoardDTO {

    record CreateRequest(
            @NotBlank(message = "제목은 필수이며, 빈 칸일 수 없습니다.")
            @Size(min = 1, max = 15)
            String title,
            @NotNull(message = "내용은 필수입니다.")
            @Size(min = 1, max = 1000)
            String content
    ) implements BoardDTO {
    }

    // 비 표준 레코드의 생성자는 다른 생성자에 위임해야 합니다 오류란?
    // 생성자를 외부로 노출할 수밖에 없으니 객체지향에 위배?
    record CreateResponse(
            Long id,
            String title,
            String content
    ) implements BoardDTO {
        public static CreateResponse of(Board board) {
            return new CreateResponse(
                    board.getId(),
                    board.getTitle(),
                    board.getContent());
        }
    }

    record ListResponse(
            Long id,
            String title,
            String content,
            LocalDateTime createTime
    ) implements BoardDTO {
            public static ListResponse of(Board board) {
                return new ListResponse(
                        board.getId(),
                        board.getTitle(),
                        board.getContent(),
                        board.getCreateTime());
            }
    }

    record DetailResponse(
            Long id,
            String title,
            String content,
            LocalDateTime createTime
    ) implements BoardDTO {
        public static DetailResponse of(Board board) {
            return new DetailResponse(
                    board.getId(),
                    board.getTitle(),
                    board.getContent(),
                    board.getCreateTime());
        }
    }

    record UpdateRequest(
            Long id,
            @NotBlank(message = "제목은 필수이며, 빈 칸일 수 없습니다.")
            @Size(min = 1, max = 15)
            String title,
            @NotNull(message = "내용은 필수입니다.")
            @Size(min = 1, max = 1000)
            String content
    ) implements BoardDTO {

    }

    record UpdateResponse(
            Long id,
            String title,
            String content
    ) implements BoardDTO {
        public static UpdateResponse of(Board board) {
            return new UpdateResponse(
                    board.getId(),
                    board.getTitle(),
                    board.getContent());
        }
    }

}
