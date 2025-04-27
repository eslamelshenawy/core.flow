package com.core.flow.shared.data.dto.otp;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VerifyOtpResponse {
    private String message;
    private String expiry;
}
