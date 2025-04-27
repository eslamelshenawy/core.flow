package com.core.flow.shared.client;


import com.core.flow.shared.data.dto.profile.CustomerBasicInfoResponse;
import com.core.flow.shared.dto.SearchByPhoneAndIdRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Primary
@FeignClient(value = "profile-service")
public interface ProfileClient {
    @PostMapping("/profiles/customers/search-by-phone-id")
    CustomerBasicInfoResponse getProfileByPhoneAndId(@RequestBody SearchByPhoneAndIdRequest request);

}
