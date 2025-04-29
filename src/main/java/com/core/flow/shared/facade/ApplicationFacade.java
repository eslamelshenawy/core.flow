package com.core.flow.shared.facade;

import com.core.flow.shared.client.ApplicationClient;
import com.core.flow.shared.client.OtpClient;
import com.core.flow.shared.client.TranslationClient;
import com.core.flow.shared.data.dto.application.ApplicationResponse;
import com.core.flow.shared.dto.ApplicationIvrDto;
import com.core.flow.shared.dto.SearchByPhoneAndIdRequest;
import com.core.flow.shared.enums.OtpCode;
import com.dgcash.common.core.data.dtos.translation.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ApplicationFacade {

    private final ApplicationClient applicationClient;
    private final OtpClient otpClient;
    private final TranslationClient translationClient;
    private static final String SPLITER = "--";


    public ApplicationResponse getApplicationByProfileId(String entityId, boolean latestOnly, String lang) {
        String[] tokenParts = entityId.split(SPLITER);
        String profileId = tokenParts[0];
        String entityIdToken = tokenParts[1];

        SearchByPhoneAndIdRequest profileRequest = new SearchByPhoneAndIdRequest(null, profileId);
        boolean isEntityIdSessionValid = otpClient.validateEntityIdSession("APPLICATION", entityIdToken);
        if (!isEntityIdSessionValid) {
            String messageCode = OtpCode.INVALID_ENTITY_TOKEN_SESSION.getCode();
            MessageDto messageDto = translationClient.getMessage(lang, messageCode, Collections.emptyMap());
            return ApplicationResponse.builder()
                    .applications(Collections.emptyList())
                    .message(messageDto.getPlainText())
                    .build();
        }

        List<ApplicationIvrDto> applications = applicationClient.getApplicationsByProfileId(profileRequest);

        if (latestOnly && !applications.isEmpty()) {
            return ApplicationResponse.builder()
                    .applications(Collections.singletonList(applications.get(applications.size() - 1)))
                    .message(null)
                    .build();
        }

        return ApplicationResponse.builder()
                .applications(applications)
                .message(null)
                .build();
    }



}
