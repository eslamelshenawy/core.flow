package com.core.flow.shared.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchByPhoneAndIdRequest {
    private String phoneNumber;
    private String idNumber;
}
