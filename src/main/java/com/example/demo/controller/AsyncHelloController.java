package com.example.demo.controller;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class AsyncHelloController {

    @GetMapping("/async/hello/{name}")
    public CompletableFuture<Object> asyncHello(@PathVariable("name") String name) {
        log.info("name: {}", name);
        return CompletableFuture.completedFuture(Map.of("body", "hello " + name));
    }

}
