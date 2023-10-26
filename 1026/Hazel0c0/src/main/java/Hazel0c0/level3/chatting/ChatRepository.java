package Hazel0c0.level3.chatting;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ChatRepository {
  private List<Message> messages = new ArrayList<>();

  public void saveMessage(Message message) {
    messages.add(message);
  }

}
