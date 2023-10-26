package level7.domain.repository;

import level7.domain.entity.Message;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ChatRepositoryList implements ChatRepository {

    private final List<Message> list;

    public ChatRepositoryList() {
        this.list = new ArrayList<>();
    }

    @Override
    public List<Message> findAllById(String uuid) {
        if (uuid.isBlank()) {
            return Collections.unmodifiableList(this.list);
        }

        List<Message> newList = new ArrayList<>();
        int index = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).toString().contains(uuid)) {
                index = i;
                break;
            }
        }

        for (int i = index + 1; i < list.size(); i++) {
            newList.add(list.get(i));
        }

        return Collections.unmodifiableList(newList);
    }

    @Override
    public Message save(Message message) {
        list.add(message);
        return message;
    }
}
