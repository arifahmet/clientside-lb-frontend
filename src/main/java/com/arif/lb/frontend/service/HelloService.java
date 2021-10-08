package com.arif.lb.frontend.service;

import com.arif.lb.frontend.client.BackendClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@Slf4j
public class HelloService {

    private final BackendClient backendClient;

    public HelloService(BackendClient backendClient) {
        this.backendClient = backendClient;
    }

    public String hello(@RequestParam(required = false) String name) {
        String res;
        try {
            Object response = backendClient.hello(name).getBody();
            if (response != null) {
                res = new ObjectMapper().writeValueAsString(response);
            } else {
                throw new Exception("{\"msg\":\"Bad Request\"}");
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage());
        }
        return res;
    }
}
