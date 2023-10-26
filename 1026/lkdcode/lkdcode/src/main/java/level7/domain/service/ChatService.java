package level7.domain.service;

import level7.domain.dto.MessageDTO;
import level7.domain.entity.Message;
import level7.domain.mapper.MessageMapper;
import level7.domain.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static level7.domain.dto.MessageDTO.CreateResponse;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatRepository chatRepository;
    private final MessageMapper messageMapper;

    public List<MessageDTO.FindResponse> loadFindAllById(String uuid) {
        List<Message> list = chatRepository.findAllById(uuid);

        return list.stream()
                .map(messageMapper::toGetFindResponse)
                .collect(Collectors.toList());
    }

    public CreateResponse loadSave(MessageDTO.CreateRequest request) {
        Message saved = chatRepository.save(messageMapper.toEntityFrom(request));
        return messageMapper.toGetCreateResponse(saved);
    }

}
