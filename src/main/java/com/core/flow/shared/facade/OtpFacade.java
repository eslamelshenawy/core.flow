
package com.core.flow.shared.facade;


//import com.core.flow.shared.client.OtpClient;

import com.core.flow.shared.client.OtpClient;
import com.core.flow.shared.client.ProfileClient;
import com.core.flow.shared.client.TranslationClient;
import com.core.flow.shared.data.dto.otp.CreateOtpRequest;
import com.core.flow.shared.data.dto.otp.OtpResponse;
import com.core.flow.shared.data.dto.otp.OtpValidationRequest;
import com.core.flow.shared.data.dto.otp.VerifyOtpResponse;
import com.core.flow.shared.util.Base64EncoderDecoder;
import com.dgcash.common.core.data.dtos.translation.MessageDto;
import com.dgcash.common.core.profile.business.exceptions.InvalidOtpException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Collections;



@Component
@RequiredArgsConstructor
public class OtpFacade {
    private final OtpClient otpClient;
    private final TranslationClient translationClient;
    private final ProfileClient profileClient;
    private Base64EncoderDecoder base64EncoderDecoder;

    private final String OTP_CREATION_SUCCESS_CODE= "OTP_CREATION_SUCCESS";
    private final String OTP_CREATION_FAILURE_CODE= "OTP_CREATION_FAILURE";


    public OtpResponse createOtp(CreateOtpRequest request) {
  /*      CustomerBasicInfoResponse profile = profileClient.getProfileByPhoneAndId(
                SearchByPhoneAndIdRequest.builder()
                        .phoneNumber(request.getMobileNumber())
                        .idNumber(request.getRequesterId().toString())
                        .build());

        if (profile == null || profile.getProfileId() == null) {
             throw new ProfileNotFoundException();
        }
*/
        request.setNotificationMethod("SMS");
        request.setOperationCode("APPLICATION");
        request.setEntityId(Base64EncoderDecoder.encodeRequesterId(request.getRequesterId()));
        OtpResponse response = otpClient.createOtp(request);

        String messageCode = response.getId() != null ? OTP_CREATION_SUCCESS_CODE : OTP_CREATION_FAILURE_CODE;
        MessageDto message = translationClient.getMessage(request.getLang(), messageCode, Collections.emptyMap());
        response.setMessage(message.getPlainText());
        return response;
    }



    public VerifyOtpResponse verifyOtp(OtpValidationRequest verifyOtpRequest) {
        Boolean isVerified = otpClient.verifyOtp(verifyOtpRequest.getType(), verifyOtpRequest.getEntityId(), verifyOtpRequest.getOtp());
        if (Boolean.TRUE.equals(isVerified)) {
            return VerifyOtpResponse.builder()
                    .message("OTP verified successfully")
                    .expiry(LocalDateTime.now().plusHours(1).toString())
                    .build();
        } else {
            throw new InvalidOtpException(); // or return a response with error message if you want
        }


    }

}

