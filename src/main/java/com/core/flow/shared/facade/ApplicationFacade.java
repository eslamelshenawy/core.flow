package com.core.flow.shared.facade;

import com.core.flow.chatbot.service.ApplicationService;
import com.core.flow.shared.client.OtpClient;
import com.core.flow.shared.data.dto.application.ApplicationDto;
import com.dgcash.common.core.components.encryption.AESAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ApplicationFacade {

    private final ApplicationService applicationService;
    private final OtpClient otpClient;


    public Page<ApplicationDto> getApplicationByProfileId(int page, int size, String sort, String direction, String entityId, boolean latestOnly) {
        boolean isEntityIdSessionValid = otpClient.validateEntityIdSession("APPLICATION", entityId);
        if (!isEntityIdSessionValid) {
            throw new IllegalStateException("Entity ID session is expired or invalid.");
        }

        Long profileId = Long.parseLong(AESAlgorithm.decrypt(entityId).toString());

        // If latestOnly is true, fetch only the latest record, sorted by ID in descending order
        if (latestOnly) {
            Page<ApplicationDto> latestPage = applicationService.getApplicationByProfileId(0, 1, sort, direction, profileId);
            return latestPage.isEmpty() ? Page.empty() : latestPage;
        }
        return applicationService.getApplicationByProfileId(page, size, sort, direction, profileId);
    }



}
