package com.harmlessprince.ecommerceApi.lga;

import com.harmlessprince.ecommerceApi.handler.CustomSuccessResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/local-governments")
public class LocalGovernmentController {

    private final LocalGovernmentRepository localGovernmentRepository;
    @GetMapping("/{stateId}")
    public CustomSuccessResponse<List<LocalGovernment>> index(@PathVariable Integer stateId) {
        List<LocalGovernment> localGovernmentList = localGovernmentRepository.findByStateId(stateId);
        return new CustomSuccessResponse<>(localGovernmentList);
    }
}
