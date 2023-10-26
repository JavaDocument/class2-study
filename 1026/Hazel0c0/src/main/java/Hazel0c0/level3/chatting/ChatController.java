package Hazel0c0.level3.chatting;

import Hazel0c0.level3.chatting.dto.MessageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatController {
  private final ChatService chatService;

  @PostMapping("/writeMessage")
  public ResponseEntity<UUID> write(MessageRequest messageRequest){
    UUID uuid = chatService.save(messageRequest);
    return ResponseEntity.ok(uuid);
  }
}
