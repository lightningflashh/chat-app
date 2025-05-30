package vn.chithanh.backend.messagecontent;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class MessageContentDTO {
    private UUID id;
    private String content;
    private LocalDateTime sentAt;
    private MessageType messageType;
    private UUID messageRoomId;
    private UUID senderId;
}
