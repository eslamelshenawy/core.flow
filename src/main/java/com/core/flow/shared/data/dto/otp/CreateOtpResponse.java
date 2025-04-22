package com.core.flow.shared.data.dto.otp;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.dgcash.common.otp.data.entities.Otp}
 */
@Value
public class CreateOtpResponse implements Serializable {
    Long id;
    String entityId;
    long otpSettingsValidityInSeconds;
}