
package com.core.flow.shared.facade;


//import com.core.flow.shared.client.OtpClient;

import com.core.flow.shared.client.OtpClient;
import com.core.flow.shared.client.ProfileClient;
import com.core.flow.shared.client.TranslationClient;
import com.core.flow.shared.data.dto.otp.CreateOtpRequest;
import com.core.flow.shared.data.dto.otp.OtpResponse;
import com.core.flow.shared.data.dto.otp.OtpValidationRequest;
import com.core.flow.shared.data.dto.otp.VerifyOtpResponse;
import com.core.flow.shared.data.dto.profile.CustomerBasicInfoResponse;
import com.core.flow.shared.dto.SearchByPhoneAndIdRequest;
import com.core.flow.shared.enums.OtpCode;
import com.dgcash.common.core.data.dtos.translation.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.UUID;


@Component
@RequiredArgsConstructor
public class OtpFacade {
    private final OtpClient otpClient;
    private final TranslationClient translationClient;
    private final ProfileClient profileClient;
    private static final String SPLITER = "--";


    public OtpResponse createOtp(CreateOtpRequest request) {
        CustomerBasicInfoResponse profile = profileClient.getProfileByPhoneAndId(
                SearchByPhoneAndIdRequest.builder()
                        .phoneNumber(request.getMobileNumber())
                        .idNumber(request.getRequesterId().toString())
                        .build());

        if (profile == null || profile.getProfileId() == null) {
            MessageDto message = translationClient.getMessage(request.getLang(), OtpCode.PROFILE_NOT_FOUND.getCode(), Collections.emptyMap());
            return OtpResponse.builder().message(message.getPlainText()).build();
        }

        request.setNotificationMethod("SMS");
        request.setOperationCode("APPLICATION");

        String encryptedToken = generateEncryptedToken(request);

        String messageCode = encryptedToken != null ? OtpCode.OTP_CREATION_SUCCESS.getCode() : OtpCode.OTP_CREATION_FAILURE.getCode();
        MessageDto message = translationClient.getMessage(request.getLang(), messageCode, Collections.emptyMap());

        return OtpResponse.builder()
                .entityId(encryptedToken)
                .message(message.getPlainText())
                .build();
    }


    private String generateEncryptedToken(CreateOtpRequest request) {
        String id = UUID.randomUUID().toString();
        return request.getRequesterId() + SPLITER + id + SPLITER + getGenerateOtp(request.getRequesterId(), id);
    }

    private String getGenerateOtp(Long requesterId, String profileId) {
        return otpClient.generateOtp(getCreateOtpRequest(requesterId, profileId));
    }

    private CreateOtpRequest getCreateOtpRequest(Long requesterId, String entityId) {
        CreateOtpRequest createOtpRequest = new CreateOtpRequest();
        createOtpRequest.setRequesterId(requesterId);
        createOtpRequest.setEntityId(entityId);
        createOtpRequest.setNotificationMethod("SMS");
        createOtpRequest.setOperationCode("APPLICATION");
        return createOtpRequest;
    }


    public VerifyOtpResponse verifyOtp(OtpValidationRequest verifyOtpRequest) {
        String entityId = verifyOtpRequest.getEntityId();
        String otp = verifyOtpRequest.getOtp();
        String lang = verifyOtpRequest.getLang();

        if (isBlank(entityId)) {
            return buildErrorResponse(lang, OtpCode.ENTITY_ID_MISSING.getCode());
        }
        if (isBlank(otp)) {
            return buildErrorResponse(lang, OtpCode.NO_OTP_FOUND.getCode());
        }

        // Validate entityId format
        String[] tokenParts = entityId.split(SPLITER);
        if (tokenParts.length < 2) {
            return buildErrorResponse(lang, OtpCode.INVALID_ENTITY_TOKEN_FORMAT.getCode());
        }

        // Verify OTP
        String actualEntityId = tokenParts[1];
        Boolean isVerified = otpClient.verifyOtp(verifyOtpRequest.getType(), actualEntityId, otp);

        if (Boolean.TRUE.equals(isVerified)) {
            return buildSuccessResponse(lang, OtpCode.OTP_VERIFIED.getCode());
        } else {
            return buildErrorResponse(lang, OtpCode.INVALID_OTP_EXCEPTION.getCode());
        }
    }


    private boolean isBlank(String str) {
        return str == null || str.isBlank();
    }

    private VerifyOtpResponse buildErrorResponse(String lang, String messageCode) {
        MessageDto message = translationClient.getMessage(lang, messageCode, Collections.emptyMap());
        return VerifyOtpResponse.builder()
                .message(message.getPlainText())
                .build();
    }

    private VerifyOtpResponse buildSuccessResponse(String lang, String messageCode) {
        MessageDto message = translationClient.getMessage(lang, messageCode, Collections.emptyMap());
        return VerifyOtpResponse.builder()
                .message(message.getPlainText())
                .expiry(LocalDateTime.now().plusHours(1).toString())
                .build();
    }

}

