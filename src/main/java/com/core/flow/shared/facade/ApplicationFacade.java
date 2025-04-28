package com.core.flow.shared.facade;

import com.core.flow.shared.client.ApplicationClient;
import com.core.flow.shared.client.OtpClient;
import com.core.flow.shared.dto.ApplicationIvrDto;
import com.core.flow.shared.dto.SearchByPhoneAndIdRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ApplicationFacade {

    private final ApplicationClient applicationClient;
    private final OtpClient otpClient;
    private static final String SPLITER = "--";


    public List<ApplicationIvrDto> getApplicationByProfileId(String entityId, boolean latestOnly) {
        String[] tokenParts = entityId.split(SPLITER);
        String profileId = tokenParts[0];
        String entityIdToken = tokenParts[1];

        SearchByPhoneAndIdRequest profileRequest = new SearchByPhoneAndIdRequest(null, profileId);
       /* boolean isEntityIdSessionValid = otpClient.validateEntityIdSession("APPLICATION", entityIdToken);
        if (!isEntityIdSessionValid) {
            throw new IllegalStateException("Entity ID session is expired or invalid.");
        }*/

        List<ApplicationIvrDto> applications = applicationClient.getApplicationsByProfileId(profileRequest);

        if (latestOnly && !applications.isEmpty()) {
            return Collections.singletonList(applications.get(applications.size() - 1));
        }

        return applications;
    }



}
