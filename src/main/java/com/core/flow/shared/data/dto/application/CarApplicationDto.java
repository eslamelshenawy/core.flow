package com.core.flow.shared.data.dto.application;

import com.core.flow.shared.data.enums.CarStatus;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

@Value
public class CarApplicationDto implements ApplicationDto , Serializable {
    Long id;
    int financingDurationMonths;
    Double applicationAmount;
    boolean hasEstateSupport;
    FinancingType financingType;
    Boolean fiftyFifty;
    String workflowStatus;
    LocalDate expiryDate;
    LocalDate createdAt;

    CarStatus carStatus;
    String dealershipName;
    String vehicleBrand;
    String vehicleModel;
    int productionYear;
    Double downPaymentAmount;
    Long profileId;
    String applicationType;
    String applicationReference;

    @Override
    public String getFinancialAttachmentToken() {
        return null;
    }

    @Override
    public InstalmentType getInstalmentType() {
        return null;
    }

    @Override
    public String getUnitDetailTypeCode() {
        return null;
    }

    @Override
    public boolean isHasDownPayment() {
        return false;
    }
}