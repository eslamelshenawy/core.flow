package com.core.flow.chatbot.controller;

import com.core.flow.shared.data.dto.application.ApplicationResponse;
import com.core.flow.shared.data.dto.otp.CreateOtpRequest;
import com.core.flow.shared.data.dto.otp.OtpResponse;
import com.core.flow.shared.data.dto.otp.OtpValidationRequest;
import com.core.flow.shared.data.dto.otp.VerifyOtpResponse;
import com.core.flow.shared.dto.ApplicationIvrDto;
import com.core.flow.shared.facade.ApplicationFacade;
import com.core.flow.shared.facade.OtpFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Log4j2
@RestController
@RequestMapping("/chatbot-integration")
@RequiredArgsConstructor
public class ChatbotController {

    private final OtpFacade otpFacade;
    private final ApplicationFacade applicationFacade;

    @PostMapping("/chatbot/create-otp")
    public ResponseEntity<OtpResponse> createOtp(@RequestBody CreateOtpRequest request) {
        OtpResponse response = otpFacade.createOtp(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/chatbot/v1/validate-otp")
    public ResponseEntity<VerifyOtpResponse> verifyOtp(@RequestBody OtpValidationRequest request) {
        VerifyOtpResponse response = otpFacade.verifyOtp(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/chatbot/get-requests")
    public ResponseEntity<ApplicationResponse> getRequestDetails(
            @RequestHeader(value = "X-ENTITY-ID", required = true) String entityId,
            @RequestParam(name = "latestOnly", required = false, defaultValue = "false") boolean latestOnly,
            @RequestHeader(name = "Accept-Language", defaultValue = "ar_SA") String lang) {

        if (entityId == null || entityId.isEmpty()) {
            ApplicationResponse errorResponse = new ApplicationResponse();
            errorResponse.setMessage("Missing X-ENTITY-ID header");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        }

        ApplicationResponse response = applicationFacade.getApplicationByProfileId(entityId, latestOnly, lang);

        if (response.getMessage() != null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        return ResponseEntity.ok(response);
    }
}
