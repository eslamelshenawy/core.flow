package com.core.flow.shared.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

//TODO to be extracted in a new common library
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JwtAuthenticationResponse implements Serializable {
    private String token;
    private Long expirationDuration;
    private Long profileId;
    private String username;
    private Long userId;
    private boolean isFirstLogin;
    private String identityNumber;
    private String tenantNumber;
    private List<JwtGroupDto> groups;

}
