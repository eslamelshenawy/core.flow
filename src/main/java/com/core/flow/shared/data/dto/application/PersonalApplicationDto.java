package com.core.flow.shared.data.dto.application;


import com.core.flow.shared.data.enums.CarStatus;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

@Value
public class PersonalApplicationDto implements ApplicationDto, Serializable {
    Long id;
    Integer financingDurationMonths;
    Double applicationAmount;
    Boolean hasEstateSupport;
    String financialAttachmentToken;
    Long profileId;
    String applicationType;
    String applicationReference;
    String workflowStatus;
    LocalDate expiryDate;
    LocalDate createdAt;

    @Override
    public boolean isHasEstateSupport() {
        return false;
    }

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

    @Override
    public InstalmentType getInstalmentType() {
        return null;
    }

    @Override
    public int getFinancingDurationMonths(){
        return 0;
    }

    @Override
    public String getUnitDetailTypeCode() {
        return "";
    }

    @Override
    public boolean isHasDownPayment() {
        return false;
    }

    @Override
    public Double getDownPaymentAmount() {
        return 0.0;
    }
}