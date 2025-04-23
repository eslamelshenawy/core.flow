package com.core.flow.shared.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class AuthResponse {
    private String token;

    public AuthResponse(String token) {
        this.token = token;
    }
}
