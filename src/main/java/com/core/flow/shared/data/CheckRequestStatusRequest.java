package com.core.flow.shared.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckRequestStatusRequest {
    private String mobileNumber;
    private String idNumber;
}

