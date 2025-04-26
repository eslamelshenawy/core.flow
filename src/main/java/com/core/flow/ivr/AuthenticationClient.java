package com.core.flow.ivr;


import com.core.flow.shared.dto.JwtAuthenticationResponse;
import com.core.flow.shared.dto.UserSigninRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "authentication-service", url = "${authentication.service.url}")
public interface AuthenticationClient {

    @PostMapping("/auth/signin")
    JwtAuthenticationResponse signin(@RequestBody UserSigninRequest request);
}
