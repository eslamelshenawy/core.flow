package com.core.flow.ivr.service;

import com.core.flow.shared.client.ApplicationServiceClient;
import com.core.flow.shared.dto.ApplicationIvrDto;
import com.core.flow.shared.dto.IvrRequest;
import com.core.flow.shared.dto.IvrResponse;
import com.core.flow.shared.dto.SearchByPhoneAndIdRequest;
import com.core.flow.shared.infrastructure.exception.InvalidUserInputException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationIntegrationService {

    private final ApplicationServiceClient applicationServiceClient;

    public List<ApplicationIvrDto> fetchApplicationsForIvr(String phoneNumber, String idNumber) {
        SearchByPhoneAndIdRequest request = new SearchByPhoneAndIdRequest(phoneNumber, idNumber);
        return applicationServiceClient.getApplicationsByPhoneAndId(request);
    }
}
