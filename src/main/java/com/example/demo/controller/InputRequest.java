package com.example.demo.controller;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class InputRequest {

    @NotEmpty(message = "required name")
    private String name;

}
