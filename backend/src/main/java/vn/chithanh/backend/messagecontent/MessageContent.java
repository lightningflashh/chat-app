package vn.chithanh.backend.messagecontent;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import vn.chithanh.backend.messageroom.MessageRoom;
import vn.chithanh.backend.user.User;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "message_contents")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class MessageContent {
    @Id
    @GeneratedValue(generator = "UUID", strategy = GenerationType.AUTO)
    private UUID id;

    private String content;

    @CreatedDate
    private LocalDateTime sentAt;

    @Enumerated(EnumType.STRING)
    private MessageType messageType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "message_room_id")
    private MessageRoom messageRoom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}
