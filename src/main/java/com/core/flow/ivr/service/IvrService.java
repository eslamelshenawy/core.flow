package com.core.flow.ivr.service;

import com.core.flow.shared.dto.IvrRequest;
import com.core.flow.shared.dto.IvrResponse;
import com.core.flow.shared.infrastructure.exception.InvalidUserInputException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class IvrService {

    public IvrResponse getApplicationDetails(IvrRequest request) {
        if ("0551234567".equals(request.getPhoneNumber()) && "1234567890".equals(request.getIdNumber())) {
            return new IvrResponse(
                    "APP-001",
                    LocalDateTime.of(2024, 5, 1, 10, 30),
                    150000.0,
                    "Personal Loan",
                    "Under Review",
                    LocalDateTime.of(2024, 5, 5, 9, 0),
                    "Submitted",
                    LocalDateTime.of(2024, 5, 3, 15, 20),
                    3,
                    null,
                    LocalDateTime.of(2024, 6, 1, 0, 0),
                    "IVR"
            );
        } else {
            throw new InvalidUserInputException("Invalid phone number or ID number.");
        }
    }

}
