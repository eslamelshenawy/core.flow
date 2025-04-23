package com.core.flow.shared.data.dto.application;


import com.core.flow.shared.data.enums.CarStatus;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;


@Value
public class EstateApplicationDto implements ApplicationDto, Serializable {
    Long id;
    int financingDurationMonths;
    Double applicationAmount;
    boolean hasEstateSupport;
    InstalmentType instalmentType;
    String unitDetailTypeCode;
    boolean hasDownPayment;
    Double downPaymentAmount;
    Long profileId;
    String applicationType;
    String applicationReference;
    String workflowStatus;
    LocalDate expiryDate;
    LocalDate createdAt;
    String financialAttachmentToken;

    @Override
    public Boolean getFiftyFifty() {
        return false;
    }

    @Override
    public CarStatus getCarStatus() {
        return null;
    }

    @Override
    public String getDealershipName() {
        return "";
    }

    @Override
    public String getVehicleBrand() {
        return "";
    }

    @Override
    public String getVehicleModel() {
        return "";
    }

    @Override
    public int getProductionYear() {
        return 0;
    }
}