package vn.chithanh.backend.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.chithanh.backend.messagecontent.MessageContent;
import vn.chithanh.backend.messageroom.MessageRoom;
import vn.chithanh.backend.messageroommeber.MessageRoomMember;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(generator = "UUID", strategy = GenerationType.AUTO)
    private UUID id;

    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    private LocalDateTime lastLogin = LocalDateTime.now();

    private String avatarUrl;

    @OneToMany(mappedBy = "createdBy")
    private List<MessageRoom> messageRooms;

    @OneToMany(mappedBy = "user")
    private List<MessageRoomMember> messageRoomMembers;

    @OneToMany(mappedBy = "user")
    private List<MessageContent> messageContents;
}
