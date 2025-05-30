package vn.chithanh.backend.messagecontent;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import vn.chithanh.backend.messageroom.MessageRoom;
import vn.chithanh.backend.messageroom.MessageRoomRepository;
import vn.chithanh.backend.user.User;
import vn.chithanh.backend.user.UserRepository;

@Component
@RequiredArgsConstructor
public class MessageContentMapper {

    private final MessageRoomRepository messageRoomRepository;
    private final UserRepository userRepository;

    public MessageContentDTO toDTO(final MessageContent content, final MessageContentDTO contentDTO) {
        contentDTO.setId(content.getId());
        contentDTO.setContent(content.getContent());
        contentDTO.setSentAt(content.getSentAt());
        contentDTO.setMessageType(content.getMessageType());
        contentDTO.setMessageRoomId(content.getMessageRoom().getId());
        contentDTO.setSenderId(content.getUser().getId());
        return contentDTO;
    }

    public MessageContent toEntity(final MessageContentDTO contentDTO ,final MessageContent content) {
        content.setId(contentDTO.getId());
        content.setContent(contentDTO.getContent());
        content.setSentAt(contentDTO.getSentAt());
        content.setMessageType(contentDTO.getMessageType());
        final MessageRoom messageRoom = contentDTO.getMessageRoomId() == null ? null
                : messageRoomRepository.findById(contentDTO.getMessageRoomId())
                        .orElseThrow(() -> new EntityNotFoundException("Room not found!"));
        content.setMessageRoom(messageRoom);
        final User user = contentDTO.getSenderId() == null ? null
                : userRepository.findById(contentDTO.getSenderId())
                .orElseThrow(() -> new EntityNotFoundException("User not found!"));
        content.setUser(user);
        return content;
    }
}
