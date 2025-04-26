package com.core.flow.shared.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationIvrDto {
    private Long applicationId;
    private String applicationType;
    private String status;
    private String createdDate;
}
