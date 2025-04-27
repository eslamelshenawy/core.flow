package com.core.flow.shared.data.dto.profile;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerBasicInfoResponse {
    private Long profileId;
    private String fullName;
    private String mobileNumber;
    private String identityNumber;
}
