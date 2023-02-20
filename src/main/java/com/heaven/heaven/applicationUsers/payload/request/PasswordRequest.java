package com.heaven.heaven.applicationUsers.payload.request;

import lombok.*;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class PasswordRequest {
    private String username;
    private String oldPassword;
    private String newPassword;
}
