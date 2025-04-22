package com.core.flow.shared.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {
   // private String token;
   // private String type = "Bearer";
    private String message;
    private long expiresAt;


}
