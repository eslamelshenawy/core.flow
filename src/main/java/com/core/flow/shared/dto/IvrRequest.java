package com.core.flow.shared.dto;
import lombok.*;

@Data
@NoArgsConstructor
public class IvrRequest {
    private String phoneNumber;
    private String idNumber;
}
