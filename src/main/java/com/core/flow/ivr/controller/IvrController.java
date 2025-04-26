package com.core.flow.ivr.controller;

import com.core.flow.ivr.service.ApplicationIntegrationService;
import com.core.flow.shared.dto.ApplicationIvrDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ivr")
public class IvrController {

    private final ApplicationIntegrationService applicationIntegrationService;

    public IvrController(ApplicationIntegrationService applicationIntegrationService) {
        this.applicationIntegrationService = applicationIntegrationService;
    }

    @GetMapping("/applications")
    public ResponseEntity<List<ApplicationIvrDto>> getApplications(
            @RequestParam String phoneNumber,
            @RequestParam String idNumber) {
        List<ApplicationIvrDto> apps = applicationIntegrationService.fetchApplicationsForIvr(phoneNumber, idNumber);
        return ResponseEntity.ok(apps);
    }
}
