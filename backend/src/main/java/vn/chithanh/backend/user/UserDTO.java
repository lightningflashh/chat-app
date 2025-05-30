package vn.chithanh.backend.user;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class UserDTO {
    private UUID id;
    private String username;
    private String password;
    private UserStatus status;
    private String avatarUrl;
}
