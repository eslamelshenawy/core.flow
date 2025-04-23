package com.core.flow.shared.client;


import com.core.flow.shared.data.dto.otp.CreateOtpRequest;
import com.core.flow.shared.data.dto.otp.OtpResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "ocetp-servi")
public interface OtpClient {
    @PostMapping("/api/v1/internal/otps")
    OtpResponse createOtp(@RequestBody CreateOtpRequest createOtpRequest);

    @GetMapping("/api/v1/internal/otps/entities/{userId}")
    Boolean verifyOtp(@RequestParam("type") String type, @PathVariable("userId") String userId, @RequestParam("otp") String otp);

    @PostMapping("/api/v1/internal/otps/no-notification")
    String generateOtp(@RequestBody CreateOtpRequest createOtpRequest);

    @GetMapping("/api/v1/internal/otps/chatbot/entities/{entityId}")
    Boolean validateEntityIdSession(@RequestParam("type") String type, @PathVariable("userId") String userId);
}

