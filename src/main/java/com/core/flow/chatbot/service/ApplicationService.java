package com.core.flow.chatbot.service;

import com.core.flow.shared.client.ApplicationClient;
import com.core.flow.shared.data.dto.application.ApplicationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplicationService {

    private final ApplicationClient applicationClient;

    public Page<ApplicationDto> getApplicationByProfileId(int page, int size, String sortBy, String direction, Long profileId) {
        return applicationClient.getByProfileId(page,size,sortBy,direction,profileId);
    }
}
