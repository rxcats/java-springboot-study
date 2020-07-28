package com.example.demo;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class UserInfoService {

    @Resource
    private UserInfoRepository repository;

    public UserInfo create(UserInfo userInfo) {
        return null;
    }

}
