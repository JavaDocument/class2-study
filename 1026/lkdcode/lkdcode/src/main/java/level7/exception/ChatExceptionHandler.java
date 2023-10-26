package level7.exception;

import level7.domain.controller.common.MessageResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ChatExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public MessageResponse<String> validException(MethodArgumentNotValidException e) {
        return MessageResponse.error(e.getBindingResult()
                .getAllErrors()
                .get(0)
                .getDefaultMessage());
    }

}
