package com.core.flow.shared.data.dto.otp;
import lombok.Data;
@Data
public class OtpValidationRequest {
    private String otp;
    private String type;
    private String entityId;
    private String mobileNumber;
}
