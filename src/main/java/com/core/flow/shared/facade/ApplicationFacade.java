package com.core.flow.shared.facade;


import com.core.flow.shared.client.ApplicationClient;
import com.core.flow.shared.client.OtpClient;
import com.core.flow.shared.dto.ApplicationIvrDto;
import com.core.flow.shared.dto.SearchByPhoneAndIdRequest;
import com.core.flow.shared.util.Base64EncoderDecoder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ApplicationFacade {

    private final ApplicationClient applicationClient;
    private final OtpClient otpClient;


    public List<ApplicationIvrDto> getApplicationByProfileId(String entityId) {
        SearchByPhoneAndIdRequest profileRequest = new SearchByPhoneAndIdRequest(null, Base64EncoderDecoder.decodeRequesterId(entityId).toString());
     /*   boolean isEntityIdSessionValid = otpClient.validateEntityIdSession("APPLICATION", entityId);
       if (!isEntityIdSessionValid) {
            throw new IllegalStateException("Entity ID session is expired or invalid.");
        }

        Long profileId = Long.parseLong(AESAlgorithm.decrypt(entityId).toString());

        if (latestOnly) {
            Page<ApplicationDto> latestPage = applicationService.getApplicationByProfileId(0, 1, sort, direction, Long.valueOf(entityId));
            return latestPage.isEmpty() ? Page.empty() : latestPage;
        }*/
        return applicationClient.getApplicationsByProfileId(profileRequest);
    }



}
