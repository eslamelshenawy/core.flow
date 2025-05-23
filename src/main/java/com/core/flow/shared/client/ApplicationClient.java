package com.core.flow.shared.client;

import com.core.flow.shared.dto.ApplicationIvrDto;
import com.core.flow.shared.dto.SearchByPhoneAndIdRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "application-service")
public interface ApplicationClient {

    @PostMapping("/chatbot/applications")
    List<ApplicationIvrDto> getApplicationsByProfileId(@RequestBody SearchByPhoneAndIdRequest request);

    @PostMapping("/ivr/applications")
    List<ApplicationIvrDto> getApplicationsByPhoneAndId(@RequestBody SearchByPhoneAndIdRequest request);


}


