package com.core.flow.shared.data.dto.application;

import com.core.flow.shared.dto.ApplicationIvrDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApplicationResponse {
    private List<ApplicationIvrDto> applications;
    private String message;
}

