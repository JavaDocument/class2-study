package Hazel0c0.level3.chatting;

import Hazel0c0.level3.chatting.dto.MessageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ChatService {
  private final ChatRepository chatRepository;

  public UUID save(MessageRequest messageRequest){
    Message message = new Message(messageRequest.getAuthorName(), messageRequest.getContent());
    chatRepository.saveMessage(message);
    return message.getUuid();
  }
}
