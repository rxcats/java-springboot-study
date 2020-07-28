package com.example.demo;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class UserInfoRepositoryTest {

    @Resource
    private UserInfoRepository repository;

    @Autowired
    private SqlSessionFactory sf;

    @BeforeEach
    void before() {
        repository.deleteByPlatformId(1L);
    }

    @Test
    void find() {

        var u = new UserInfo();
        u.setPlatformId(1L);
        u.setState("J");
        u.setUsername("1");
        u.setJoinTs(System.currentTimeMillis());
        u.setLastLoginTs(System.currentTimeMillis());

        var insert = repository.insert(u);
        log.info("{}", insert);
        log.info("{}", u);

        var find = repository.findByPlatformId(1L);
        log.info("{}", find);
    }

    @Test
    void session() {

        try (var session =  sf.openSession(false)) {
            //sql

            session.commit();
        }

    }

}
