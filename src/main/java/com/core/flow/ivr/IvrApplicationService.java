package com.core.flow.ivr;

import com.core.flow.shared.data.*;
import com.core.flow.shared.data.dto.otp.OtpValidationRequest;
import com.core.flow.shared.events.CustomerContactedEvent;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IvrApplicationService {
    Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    private final ApplicationEventPublisher eventPublisher;

    public JwtResponse validateOtp(OtpValidationRequest request) {
        if (!"0000".equals(request.getOtp()))
            throw new IllegalArgumentException("InvalidOTP");

        if(request.getEntityId() == null || request.getEntityId().isEmpty())
            throw new IllegalArgumentException("EntityId can not be null");

        if(!request.getEntityId().equals("1719c32a-32f8-4d7b-825d-7cfd639512b6") )
            throw new IllegalArgumentException("Invalid entity id provided.");

        long expirationMillis = 1000 * 60 * 60;
        long nowMillis = System.currentTimeMillis();
        long expiryMillis = nowMillis + expirationMillis;

        String token = Jwts.builder()
                .setSubject(request.getMobileNumber())
                .setIssuedAt(new Date(nowMillis))
                .setExpiration(new Date(expiryMillis))
                .signWith(key)
                .compact();

        return JwtResponse.builder()
                .message("OTP has been verified successfully..")
                .expiresAt(expiryMillis)
                .build();
    }

    public CheckRequestStatusResponse createOtp(CheckRequestStatusRequest request) {
        if ("1234567890".equals(request.getIdNumber()) &&"1234567890".equals((request.getMobileNumber()))) {
            return CheckRequestStatusResponse.builder()
                    .entityId("1719c32a-32f8-4d7b-825d-7cfd639512b6")
                    .message("OTP has been sent on registered mobile number.")
                    .build();
        } else {
            return CheckRequestStatusResponse.builder()
                    .entityId(null)
                    .message("Invalid ID Number")
                    .build();
        }
    }

    public GetRequestDetailsResponse getDetails(Boolean lastestOnly) {
        List<ApplicationDetails> applications = Arrays.asList(
                ApplicationDetails.builder()
                        .applicationNumber("APP-001")
                        .creationDateTime(LocalDateTime.of(2024, 5, 1, 10, 30))
                        .financeAmount(150000.0)
                        .financeType("Personal Loan")
                        .requestStatus("Under Review")
                        .lastStatusDateTime(LocalDateTime.of(2024, 5, 5, 9, 0))
                        .previousStatus("Submitted")
                        .previousStatusDateTime(LocalDateTime.of(2024, 5, 3, 15, 20))
                        .numberOfFinancingEntities(3)
                        .rejectionReason(null)
                        .offerExpiryDate(LocalDateTime.of(2024, 6, 1, 0, 0))
                        .channel("ChatBot")
                        .build(),

                ApplicationDetails.builder()
                        .applicationNumber("APP-002")
                        .creationDateTime(LocalDateTime.of(2024, 4, 15, 14, 45))
                        .financeAmount(250000.0)
                        .financeType("Real Estate Finance")
                        .requestStatus("Approved")
                        .lastStatusDateTime(LocalDateTime.of(2024, 4, 20, 11, 15))
                        .previousStatus("Under Review")
                        .previousStatusDateTime(LocalDateTime.of(2024, 4, 18, 16, 0))
                        .numberOfFinancingEntities(2)
                        .rejectionReason(null)
                        .offerExpiryDate(LocalDateTime.of(2024, 5, 20, 0, 0))
                        .channel("ChatBot")
                        .build(),

                ApplicationDetails.builder()
                        .applicationNumber("APP-003")
                        .creationDateTime(LocalDateTime.of(2024, 3, 10, 9, 10))
                        .financeAmount(100000.0)
                        .financeType("Auto Lease Finance")
                        .requestStatus("Declined")
                        .lastStatusDateTime(LocalDateTime.of(2024, 3, 15, 10, 0))
                        .previousStatus("Under Review")
                        .previousStatusDateTime(LocalDateTime.of(2024, 3, 12, 13, 30))
                        .numberOfFinancingEntities(1)
                        .rejectionReason("Low Credit Score")
                        .offerExpiryDate(null)
                        .channel("ChatBot")
                        .build()
        );

        List<ApplicationDetails> result = lastestOnly
                ? List.of(applications.get(2))
                : applications;

        return GetRequestDetailsResponse.builder()
                .status(true)
                .applications(result)
                .message("Success")
                .build();
    }


    public void handleIvrInteraction(String customerId) {
        System.out.println("IVR handled call for customer: " + customerId);

        // Publish an event to notify other modules (like CRM)
        eventPublisher.publishEvent(new CustomerContactedEvent(customerId));
    }
}
