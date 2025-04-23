package com.core.flow.shared.data.dto.application;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 */
@Data
public class FeApplicationDto implements Serializable {
    private Long id;
    private Long applicationId;
    private Integer financingDurationMonths;
    private Double applicationAmount;
    private Boolean hasEstateSupport;
    private Long customerId;
    private String applicationType;
    private Long applicationReference;
    private LocalDate expiryDate;
    private String customerName;
    private String financialEntityId;
    private String criteriaName;
    private LocalDate lastModifiedAt;
    private String workflowStatus;

    // it will be 3 types
    private ApplicationDto mainApplicationDto;
}