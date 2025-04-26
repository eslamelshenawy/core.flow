package com.core.flow.shared.dto;

import lombok.Value;

import java.io.Serializable;
import java.util.Set;

@Value
public class JwtGroupDto implements Serializable {
    Long id;
    String code;
    Set<JwtRoleDto> roles;

    @Value
    public static class JwtRoleDto implements Serializable {
        Long id;
        String code;
        Set<JwtPrivilegeDto> privileges;
    }

    @Value
    public static class JwtPrivilegeDto implements Serializable {
        Long id;
        String code;
    }
}