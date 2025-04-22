/*
package com.core.flow.shared.facade;


//import com.core.flow.shared.client.OtpClient;
import com.core.flow.shared.data.dto.VerifyOtpRequest;
import com.core.flow.shared.data.dto.otp.CreateOtpRequest;
import com.core.flow.shared.data.dto.otp.OtpResponse;
import com.core.flow.shared.data.dto.otp.OtpValidationRequest;
import com.core.flow.shared.data.dto.otp.VerifyOtpResponse;
import com.dgcash.common.authorization.util.CurrentUserThreadLocal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import com.dgcash.common.core.profile.business.exceptions.InvalidOtpException;

import java.util.UUID;

import static java.util.Optional.ofNullable;

@Component
@RequiredArgsConstructor
public class OtpFacade {
    private final OtpClient otpClient;

    public OtpResponse createOtp(CreateOtpRequest request) {
        request.setNotificationMethod("SMS");
        request.setOperationCode("APPLICATION");
        request.setEntityId(UUID.randomUUID().toString());
        return otpClient.createOtp(request);
    }


    public VerifyOtpResponse verifyOtp(OtpValidationRequest verifyOtpRequest) {
        return ofNullable(otpClient.verifyOtp(verifyOtpRequest.getType(), verifyOtpRequest.getEntityId(), verifyOtpRequest.getOtp()))
                .filter(b -> b.equals(Boolean.TRUE))
                .map(b -> VerifyOtpResponse.builder().isVerified(b).build())
                .orElseThrow(InvalidOtpException::new);
    }

}
*/
