package com.core.flow.shared.data.dto.application;


import com.core.flow.shared.data.enums.CarStatus;

import java.time.LocalDate;

public interface ApplicationDto {
    Long getId();

    int getFinancingDurationMonths();

    Double getApplicationAmount();

   boolean isHasEstateSupport();

   String getFinancialAttachmentToken();

    Boolean getFiftyFifty();

    String getWorkflowStatus();

    LocalDate getExpiryDate();

    LocalDate getCreatedAt();

    CarStatus getCarStatus();

    String getDealershipName();

    String getVehicleBrand();

    String getVehicleModel();

    int getProductionYear();

    InstalmentType getInstalmentType();

    String getUnitDetailTypeCode();

    abstract boolean isHasDownPayment();

    public abstract Double getDownPaymentAmount();

    public abstract Long getProfileId();

    public abstract String getApplicationType();

    public abstract String getApplicationReference();
}
