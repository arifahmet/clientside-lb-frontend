package com.arif.lb.frontend.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "lb-backend-deployment")
public interface BackendClient {
    @GetMapping(value = "api/v1/hello", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> hello(@RequestParam(required = false) String name);
}
