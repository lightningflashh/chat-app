package vn.chithanh.backend.messageroom;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import vn.chithanh.backend.messagecontent.MessageContent;
import vn.chithanh.backend.messageroommeber.MessageRoomMember;
import vn.chithanh.backend.user.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "message_rooms")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class MessageRoom {
    @Id
    @GeneratedValue(generator = "UUID", strategy = GenerationType.AUTO)
    private UUID id;

    private String name;

    private Boolean isGroup;

    @CreatedDate
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by")
    private User createdBy;

    @OneToMany(mappedBy = "messageRoom", cascade = CascadeType.ALL)
    private List<MessageRoomMember> members;

    @OneToMany(mappedBy = "messageRoom", cascade = CascadeType.ALL)
    private List<MessageContent> messageContents;
}
