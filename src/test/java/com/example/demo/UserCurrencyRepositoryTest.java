package com.example.demo;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class UserCurrencyRepositoryTest {

    @Resource
    private UserCurrencyRepository repository;

    @Test
    void select() {
        var uc = new UserCurrency();
        uc.setUserId(1L);
        uc.setGold(100L);
        uc.setCash(10L);
        uc.setPaidCash(0L);

        var insert = repository.insert(uc);
        log.info("{}", insert);

        var c = repository.selectOne(1L);
        log.info("{}", c);
    }

}