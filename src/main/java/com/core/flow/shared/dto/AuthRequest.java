package com.core.flow.shared.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class AuthRequest {
    private String username;
    private String password;
}

