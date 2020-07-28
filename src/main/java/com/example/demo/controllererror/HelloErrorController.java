package com.example.demo.controllererror;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class HelloErrorController {

    @ExceptionHandler(HelloException.class)
    public ResponseEntity<Map<String, Object>> error(HelloException e) {

        log.error(e.getMessage(), e);

        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(Map.of("body", "error"));
    }

    @GetMapping("/hello/error")
    public ResponseEntity<Map<String, Object>> helloError() {
        throw new HelloException();
    }

}
