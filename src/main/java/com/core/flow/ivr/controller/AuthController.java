package com.core.flow.ivr.controller;

import com.core.flow.ivr.AuthenticationClient;
import com.core.flow.shared.dto.UserSigninRequest;
import com.core.flow.shared.dto.JwtAuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationClient authenticationClient;

    @PostMapping("/login")
    public ResponseEntity<JwtAuthenticationResponse> login(@RequestBody UserSigninRequest request) {
        JwtAuthenticationResponse response = authenticationClient.signin(request);
        return ResponseEntity.ok(response);
    }
}
