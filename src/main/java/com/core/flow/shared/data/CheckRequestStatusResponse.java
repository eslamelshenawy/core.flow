package com.core.flow.shared.data;

import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class CheckRequestStatusResponse {
    //private String profileId;
    private String entityId;
    private String message;
}