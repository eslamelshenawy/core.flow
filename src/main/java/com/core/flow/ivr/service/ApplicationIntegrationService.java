package com.core.flow.ivr.service;

import com.core.flow.shared.client.ApplicationClient;
import com.core.flow.shared.dto.ApplicationIvrDto;
import com.core.flow.shared.dto.SearchByPhoneAndIdRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationIntegrationService {

    private final ApplicationClient applicationServiceClient;

    public List<ApplicationIvrDto> fetchApplicationsForIvr(String phoneNumber, String idNumber) {
        SearchByPhoneAndIdRequest request = new SearchByPhoneAndIdRequest(phoneNumber, idNumber);
        return applicationServiceClient.getApplicationsByPhoneAndId(request);
    }
}
