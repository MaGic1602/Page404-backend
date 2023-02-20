package com.heaven.heaven.applicationUsers.payload.request;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class EmailRequest {
    private String username;
    private String oldEmail;
    private String newEmail;
}
