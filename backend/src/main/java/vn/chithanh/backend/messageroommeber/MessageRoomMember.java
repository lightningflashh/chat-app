package vn.chithanh.backend.messageroommeber;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.chithanh.backend.messageroom.MessageRoom;
import vn.chithanh.backend.user.User;

import java.time.LocalDateTime;

@Entity
@Table(name = "message_room_member")
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(MessageRoomMemberKey.class)
public class MessageRoomMember {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "message_room_id")
    private MessageRoom messageRoom;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private Boolean isAdmin;

    private LocalDateTime lastSeen;
}
