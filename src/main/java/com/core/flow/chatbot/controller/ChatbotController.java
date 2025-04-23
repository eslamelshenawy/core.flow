package com.core.flow.chatbot.controller;

import com.core.flow.shared.data.dto.application.ApplicationDto;
import com.core.flow.shared.data.dto.otp.CreateOtpRequest;
import com.core.flow.shared.data.dto.otp.OtpResponse;
import com.core.flow.shared.data.dto.otp.OtpValidationRequest;
import com.core.flow.shared.data.dto.otp.VerifyOtpResponse;
import com.core.flow.shared.facade.ApplicationFacade;
import com.core.flow.shared.facade.OtpFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Page<ApplicationDto>> getRequestDetails(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "createdAt") String sortBy,
            @RequestParam(defaultValue = "DESC") String direction,
            @RequestHeader(value = "X-ENTITY-ID", required = true) String entityId,
            @RequestParam(name = "latestOnly", required = false, defaultValue = "false") boolean latestOnly) {

        if (entityId == null || entityId.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                    Page.empty()
            );
        }

        Page<ApplicationDto> response = applicationFacade.getApplicationByProfileId(page, size, sortBy, direction, entityId, latestOnly);
        return ResponseEntity.ok(response);
    }


}
