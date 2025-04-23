package com.core.flow.shared.data.dto.application;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmploymentInfoDto {
    private double salary;
    private String sectorTypeCode;
    private Integer age;
    private Integer employment;
    private Double residualValue;
    private String nationalityCode;
    private String customerName;
    private String identityNumber;
    private String dateOfBirth;
    private Boolean active;
    private Double basicWage;
    private Double fullWage;
    private String gosinumber;
    private String commercialRegistrationNumber;
    private String employerName;
    private String employmentStatus;


    private Integer maritalStatus;
    private String idExpiryDate;
    private String arabicFirstName;
    private String englishFirstName;
    private String arabicSecondName;
    private String englishSecondName;
    private String arabicThirdName;
    private String englishThirdName;
    private String arabicLastName;
    private String englishLastName;
    //private Gender gender;
    private String mobileNumber;
    private String city;
    private Double debtBurdenRatioValue;
}
