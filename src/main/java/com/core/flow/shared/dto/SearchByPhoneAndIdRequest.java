package com.core.flow.shared.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchByPhoneAndIdRequest {
    private String phoneNumber;
    private String idNumber;
}
