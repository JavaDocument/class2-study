package level8.exception;

import level8.domain.controller.common.PostResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PostExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public PostResponse<String> catchExceptionFromValid(MethodArgumentNotValidException e) {
        return PostResponse.error(
                e.getBindingResult()
                        .getAllErrors()
                        .get(0)
                        .getDefaultMessage()
        );
    }

    @ExceptionHandler(NullPointerException.class)
    public PostResponse<String> catchNullPointerException(NullPointerException e) {
        return PostResponse.error(e.getMessage());
    }

}
