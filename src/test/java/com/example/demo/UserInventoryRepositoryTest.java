package com.example.demo;

import javax.annotation.Resource;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class UserInventoryRepositoryTest {

    //@Autowired
    @Resource
    private UserInventoryRepository repository;

    @BeforeEach
    void before() {
        var del = repository.deleteByUserId(1L);
        log.info("del:{}", del);
    }

    @Test
    void insert() {
        var cnt = repository.insert(1L, 1L, 1);
        log.info("cnt:{}", cnt);

        var cnt2 = repository.insert(1L, 2L, 1);
        log.info("cnt2:{}", cnt2);

        var all = repository.selectAllByUserId(1L);

        for (var e : all) {
            log.info("e:{}", e);
        }
    }

    @Test
    void update() {
        var insert = repository.insert(1L, 1L, 1);
        log.info("insert:{}", insert);

        var update = repository.update(1L, 1L, 10);
        log.info("update:{}", update);

        var select = repository.selectOne(1L, 1L);
        log.info("select:{}", select);
    }

}