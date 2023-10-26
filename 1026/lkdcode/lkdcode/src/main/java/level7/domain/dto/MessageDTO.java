package level7.domain.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

import static level7.domain.dto.MessageDTO.*;

public sealed interface MessageDTO permits CreateRequest, CreateResponse, FindResponse {
    record CreateRequest(
            @NotBlank(message = "작성자 기입 필수")
            String authorName,
            @NotBlank(message = "내용 기입 필수")
            String content
    ) implements MessageDTO {
    }

    record CreateResponse(
            String uuid
    ) implements MessageDTO {
    }

    record FindResponse(
            String uuid,
            LocalDateTime createDate,
            String authorName,
            String content
    ) implements MessageDTO {
    }

}
