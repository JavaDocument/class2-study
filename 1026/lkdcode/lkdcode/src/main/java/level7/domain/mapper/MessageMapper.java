package level7.domain.mapper;

import level7.domain.dto.MessageDTO;
import level7.domain.entity.Message;
import org.springframework.stereotype.Component;

@Component
public class MessageMapper {

    public MessageDTO.CreateResponse toGetCreateResponse(Message message) {
        return new MessageDTO.CreateResponse(message.getUuid().toString());
    }

    public MessageDTO.FindResponse toGetFindResponse(Message message) {
        return new MessageDTO.FindResponse(
                message.getUuid().toString(),
                message.getCreateDate(),
                message.getAuthorName(),
                message.getContent()
        );
    }

    public Message toEntityFrom(MessageDTO.CreateRequest request) {
        return new Message(request.authorName(), request.content());
    }

}
