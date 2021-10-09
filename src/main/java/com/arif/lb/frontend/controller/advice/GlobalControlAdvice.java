package com.arif.lb.frontend.controller.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalControlAdvice {

    @ExceptionHandler(value = {RuntimeException.class})
    public ResponseEntity<Object> handleRuntimeException(RuntimeException e) {
        return ResponseEntity.badRequest().body("{\"errorMsg\":\"" + e.getMessage() + "\"");
    }
}
