package com.core.flow.shared.data.dto.otp;

import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link com.dgcash.common.otp.data.entities.Otp}
 */
@Data
public class CreateOtpRequest implements Serializable {
    private String entityId;
    private Long requesterId;
    private String operationCode;
    private String recipient;
    private String notificationMethod;
    private String local = "en_UK";
}