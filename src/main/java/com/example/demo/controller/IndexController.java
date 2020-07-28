package com.example.demo.controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class IndexController {

    @GetMapping("/index")
    public String index(Model model) {

        model.addAttribute("title", "index page");

        return "index";
    }
}
