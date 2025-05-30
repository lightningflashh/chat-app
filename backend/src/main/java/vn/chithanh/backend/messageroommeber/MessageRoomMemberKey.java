package vn.chithanh.backend.messageroommeber;

import lombok.Data;
import vn.chithanh.backend.messageroom.MessageRoom;
import vn.chithanh.backend.user.User;

import java.io.Serializable;
import java.util.UUID;

@Data
public class MessageRoomMemberKey implements Serializable {
    private UUID user;
    private UUID messageRoom;
}
