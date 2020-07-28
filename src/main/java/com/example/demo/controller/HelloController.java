package com.example.demo.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// @RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class HelloController {

    @GetMapping(path = "/hello/{name}")
    public Map<String, Object> hello(@PathVariable(value = "name", required = false) String name) {
        log.info("{}", name);
        return Map.of("body", "hello " + name);
    }

}
