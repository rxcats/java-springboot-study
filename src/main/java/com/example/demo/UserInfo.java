package com.example.demo;

import lombok.Data;

@Data
public class UserInfo {
    private Long userId;

    private Long platformId;

    private String state;

    private String username;

    private Long lastLoginTs;

    private Long joinTs;
}
