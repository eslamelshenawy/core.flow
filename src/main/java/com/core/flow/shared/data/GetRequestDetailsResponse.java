package com.core.flow.shared.data;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetRequestDetailsResponse {
    private boolean status;
    private List<ApplicationDetails> applications;
    private String message;
}
