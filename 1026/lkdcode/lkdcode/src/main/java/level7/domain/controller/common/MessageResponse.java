package level7.domain.controller.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

@JsonPropertyOrder({"resultCode", "msg", "data"})
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
public class MessageResponse<T> {
    private final String resultCode;
    private final String msg;
    private final T data;

    MessageResponse(String msg, T data) {
        this.resultCode = "S-1";
        this.msg = msg;
        this.data = data;
    }

    public static <T> MessageResponse<T> ok(T data) {
        return new MessageResponse<>("성공", data);
    }

    public static <T> MessageResponse<T> error(T message) {
        return new MessageResponse<>("에러", message);
    }

}
