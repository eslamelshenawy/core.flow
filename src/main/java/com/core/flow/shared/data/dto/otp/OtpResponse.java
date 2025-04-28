package com.core.flow.shared.data.dto.otp;

import lombok.Data;
import lombok.Value;
import lombok.Builder;

import java.io.Serializable;

/**
 * DTO for {@link com.dgcash.common.otp.data.entities.Otp}
 */
@Data
@Builder
public class OtpResponse implements Serializable {
    Long id;
    String entityId;
    String message;
}