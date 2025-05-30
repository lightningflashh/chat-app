package vn.chithanh.backend.messageroom;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import vn.chithanh.backend.user.User;
import vn.chithanh.backend.user.UserRepository;

@Component
@RequiredArgsConstructor
public class MessageRoomMapper {

    private final UserRepository userRepository;

    public MessageRoomDTO toDTO(final MessageRoom messageRoom, final MessageRoomDTO messageRoomDTO) {
        messageRoomDTO.setId(messageRoom.getId());
        messageRoomDTO.setName(messageRoom.getName());
        messageRoomDTO.setIsGroup(messageRoom.getIsGroup());
        messageRoomDTO.setCreatedAt(messageRoom.getCreatedAt());
        messageRoomDTO.setCreatedById(messageRoom.getCreatedBy().getId());
        return messageRoomDTO;
    }


    public MessageRoom toEntity(final MessageRoomDTO messageRoomDTO, final MessageRoom messageRoom) {
        messageRoom.setId(messageRoomDTO.getId());
        messageRoom.setName(messageRoomDTO.getName());
        messageRoom.setIsGroup(messageRoomDTO.getIsGroup());
        messageRoom.setCreatedAt(messageRoomDTO.getCreatedAt());
        final User createdBy = messageRoomDTO.getCreatedById() == null ? null
                    : userRepository.findById(messageRoomDTO.getCreatedById())
                            .orElseThrow(() -> new EntityNotFoundException("User not found"));
        messageRoom.setCreatedBy(createdBy);
        return messageRoom;
    }
}
