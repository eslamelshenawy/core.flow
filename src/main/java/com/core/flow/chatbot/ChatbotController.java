package com.core.flow.chatbot;

import com.core.flow.ivr.IvrApplicationService;
import com.core.flow.shared.data.CheckRequestStatusRequest;
import com.core.flow.shared.data.CheckRequestStatusResponse;
import com.core.flow.shared.data.GetRequestDetailsResponse;
import com.core.flow.shared.data.JwtResponse;
import com.core.flow.shared.data.dto.otp.OtpValidationRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("/chatbot-integration")
@RequiredArgsConstructor
public class ChatbotController {

    private final IvrApplicationService ivrApplicationService;

    @PostMapping("/chatbot/create-otp")
    public ResponseEntity<CheckRequestStatusResponse> checkRequestStatus(@RequestBody CheckRequestStatusRequest request) {
        CheckRequestStatusResponse response = ivrApplicationService.createOtp(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/chatbot/v1/validate-otp")
    public ResponseEntity<JwtResponse> validateOtp(@Valid @RequestBody OtpValidationRequest otpRequest) {
        JwtResponse jwtResponse = ivrApplicationService.validateOtp(otpRequest);
        return ResponseEntity.ok(jwtResponse);
    }


    @GetMapping("/chatbot/get-requests")
    public ResponseEntity<GetRequestDetailsResponse> getRequestDetails(
            @RequestHeader(value = "X-ENTITY-ID", required = true) String entityId,
            @RequestParam(name = "latestOnly", required = false, defaultValue = "false") boolean latestOnly) {

        if (entityId  == null || entityId.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                    GetRequestDetailsResponse.builder()
                            .status(false)
                            .message("Missing or invalid entityId")
                            .build()
            );
        }

        GetRequestDetailsResponse response = ivrApplicationService.getDetails(latestOnly);
        return ResponseEntity.ok(response);
    }

}
