package level8.domain.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

import java.time.LocalDateTime;

import static level8.domain.dto.PostDTO.*;

public sealed interface PostDTO permits Response, CreateRequest, CreateResponse, UpdateRequest, UpdateResponse {
    @Builder
    record Response(
            Long id,
            LocalDateTime createDate,
            LocalDateTime modifyDate,
            String subject,
            String content

    ) implements PostDTO {
    }

    record CreateRequest(
            @NotEmpty(message = "제목을 입력해주세요.")
            String subject,
            @NotEmpty(message = "내용을 입력해주세요.")
            String content
    ) implements PostDTO {
    }

    record CreateResponse(
            Long id
    ) implements PostDTO {
    }

    record UpdateRequest(
            @NotEmpty(message = "수정할 제목을 입력해주세요.")
            String subject,
            @NotEmpty(message = "수정할 내용을 입력해주세요.")
            String content
    ) implements PostDTO {
    }

    record UpdateResponse(
            Long id
    ) implements PostDTO {
    }

}