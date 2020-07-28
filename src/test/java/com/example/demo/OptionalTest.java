package com.example.demo;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OptionalTest {

    @Test
    void test() {
        var v = Optional.of(1);

        Integer r = v.get();

        log.info("{}", r);

    }
}
