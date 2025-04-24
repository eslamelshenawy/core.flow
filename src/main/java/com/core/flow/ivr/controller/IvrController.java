package com.core.flow.ivr.controller;

import com.core.flow.ivr.service.IvrService;
import com.core.flow.shared.dto.ApiResponse;
import com.core.flow.shared.dto.IvrRequest;
import com.core.flow.shared.dto.IvrResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ivr")
public class IvrController {

    @Autowired
    private IvrService ivrService;

    @PostMapping("/application-details")
    public ApiResponse<IvrResponse> getApplicationDetails(@RequestBody IvrRequest request) {
        IvrResponse response = ivrService.getApplicationDetails(request);
        return new ApiResponse<IvrResponse>("SUCCESS", "Application found successfully.", response);
    }
}
