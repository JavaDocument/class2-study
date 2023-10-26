package level7.domain.controller;

import jakarta.validation.Valid;
import level7.domain.controller.common.MessageResponse;
import level7.domain.dto.MessageDTO;
import level7.domain.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;

    @PostMapping("/chat/writeMessage")
    @ResponseStatus(OK)
    public MessageResponse<MessageDTO.CreateResponse> createChat(@RequestBody @Valid MessageDTO.CreateRequest request) {
        MessageDTO.CreateResponse createResponse = chatService.loadSave(request);
        return MessageResponse.ok(createResponse);
    }

    @GetMapping("/chat/messages")
    public MessageResponse<List<MessageDTO.FindResponse>> getChatById(@RequestParam(name = "fromUuid", defaultValue = "") String fromUuid) {
        List<MessageDTO.FindResponse> findAllResponse = chatService.loadFindAllById(fromUuid);
        return MessageResponse.ok(findAllResponse);
    }

}
