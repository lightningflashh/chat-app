package vn.chithanh.backend.messageroommeber;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import vn.chithanh.backend.messageroom.MessageRoom;
import vn.chithanh.backend.messageroom.MessageRoomRepository;
import vn.chithanh.backend.user.User;
import vn.chithanh.backend.user.UserRepository;

@Component
@RequiredArgsConstructor
public class MessageRoomMemberMapper {
    private final UserRepository userRepository;
    private final MessageRoomRepository messageRoomRepository;


    public MessageRoomMemberDTO toDTO(final MessageRoomMember messageRoomMember, final MessageRoomMemberDTO messageRoomMemberDTO) {
        messageRoomMemberDTO.setRoomId(messageRoomMember.getMessageRoom().getId());
        messageRoomMemberDTO.setUserId(messageRoomMember.getUser().getId());
        messageRoomMemberDTO.setIsAdmin(messageRoomMember.getIsAdmin());
        messageRoomMemberDTO.setLastSeen(messageRoomMember.getLastSeen());
        messageRoomMemberDTO.setLastLogin(messageRoomMember.getUser().getLastLogin());
        return messageRoomMemberDTO;
    }


    public MessageRoomMember toEntity(final MessageRoomMemberDTO messageRoomMemberDTO, final MessageRoomMember messageRoomMember) {
        final MessageRoom messageRoom = messageRoomMemberDTO.getRoomId() == null ? null
                            : messageRoomRepository.findById(messageRoomMemberDTO.getRoomId())
                                .orElseThrow(() -> new EntityNotFoundException("MessageRoom not found"));
        messageRoomMember.setMessageRoom(messageRoom);
        final User createdBy = messageRoomMemberDTO.getUserId() == null ? null
                : userRepository.findById(messageRoomMemberDTO.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        messageRoomMember.setUser(createdBy);
        messageRoomMember.setIsAdmin(messageRoomMemberDTO.getIsAdmin());
        messageRoomMember.setLastSeen(messageRoomMemberDTO.getLastSeen());
        return messageRoomMember;
    }
}
