package com.oauth2.sso.delegate;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "USER-FRAUD-CHECK-SERVICE")
//@Component
public interface FraudCheckServiceDelegate {
    @GetMapping(value = "/teamup/api/user/fraudcheck/check/{userId}", consumes = "application/json", produces = "application/json")
    public String checkFraud(@PathVariable String userId);
}
