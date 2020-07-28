package com.example.demo.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class InputValidationController {
    @PostMapping(path = "/input")
    public Map<String, Object> input(@Valid @RequestBody InputRequest req) {
        log.info("{}", req);
        return Map.of("body", "hello " + req.getName());
    }
}
