package level7.domain.repository;

import level7.domain.entity.Message;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepository {
    List<Message> findAllById(String uuid);

    Message save(Message message);
}
