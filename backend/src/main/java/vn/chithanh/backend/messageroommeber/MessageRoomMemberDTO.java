package vn.chithanh.backend.messageroommeber;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class MessageRoomMemberDTO {
    private UUID roomId;
    private UUID userId;
    private Boolean isAdmin;
    private LocalDateTime lastSeen;
    private LocalDateTime lastLogin;
}
