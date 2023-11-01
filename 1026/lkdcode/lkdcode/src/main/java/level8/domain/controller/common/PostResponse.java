package level8.domain.controller.common;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@JsonPropertyOrder({"resultCode", "msg", "data"})
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
public class PostResponse<T> {
    private String resultCode;
    private String msg;
    private T data;

    public PostResponse(String resultCode, String msg, T data) {
        this.resultCode = resultCode;
        this.msg = msg;
        this.data = data;
    }

    public static <T> PostResponse<T> ok(T data) {
        return new PostResponse<>("S-1", "성공", data);
    }

    public static <T> PostResponse<T> error(T data) {
        return new PostResponse<>("S-1", "실패", data);
    }

}
