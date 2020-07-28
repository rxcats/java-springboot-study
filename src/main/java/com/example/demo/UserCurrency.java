package com.example.demo;

import lombok.Data;

@Data
public class UserCurrency {
    private Long userId;

    private Long gold;

    private Long cash;

    private Long paidCash;
}
