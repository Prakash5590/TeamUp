package com.oauth2.sso.delegate;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "user-fraud-check-service")
@Component
public interface FraudCheckServiceDelegate {
    @GetMapping("/teamup/api/user/fraudcheck/check/{userId}")
    public boolean checkFraud(String userId);
}
