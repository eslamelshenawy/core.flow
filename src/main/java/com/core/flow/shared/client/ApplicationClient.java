package com.core.flow.shared.client;

import com.core.flow.shared.data.dto.application.ApplicationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "application-service")
public interface ApplicationClient {

    @GetMapping("/chatbot/profiles/applications")
    Page<ApplicationDto> getByProfileId(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "createdAt") String sortBy,
            @RequestParam(defaultValue = "DESC") String direction,
            @RequestParam(required = true) Long profileId
    );



}


