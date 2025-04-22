package com.core.flow.shared.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class ApplicationDetails {
    private String applicationNumber;
    private LocalDateTime creationDateTime;
    private Double financeAmount;
    private String financeType;
    private String requestStatus;
    private LocalDateTime lastStatusDateTime;
    private String previousStatus;
    private LocalDateTime previousStatusDateTime;
    private Integer numberOfFinancingEntities;
    private String rejectionReason;
    private LocalDateTime offerExpiryDate;
    private String channel;
}

