package com.example.demo.bean;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import static com.example.demo.bean.BeanExample.Apple;
import static com.example.demo.bean.BeanExample.Banana;

@Slf4j
@Service
public class BeanService {

    @Qualifier("apple1")
    @Autowired
    private Apple apple1;

    @Qualifier("apple2")
    @Autowired
    private Apple apple2;

    @Autowired
    private Banana banana;

    @Autowired
    private ApplicationContext ctx;

    @PostConstruct
    public void init() {
        log.info("//////////////////////////");
        log.info("{} {}", apple1, apple2);
        log.info("{}", banana);

        log.info("{}", ctx.getBean(Banana.class));
        log.info("{}", ctx.getBean("apple1"));
        log.info("//////////////////////////");
    }

}
