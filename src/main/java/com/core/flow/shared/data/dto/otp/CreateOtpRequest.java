package com.core.flow.shared.data.dto.otp;

import lombok.Data;

import java.io.Serializable;

@Data
public class CreateOtpRequest implements Serializable {
    private String entityId;
    private Long requesterId;
    private String operationCode;
    private String mobileNumber;
    private String notificationMethod;
    private String lang;


}