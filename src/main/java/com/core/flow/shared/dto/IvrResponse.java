package com.core.flow.shared.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class IvrResponse {
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
