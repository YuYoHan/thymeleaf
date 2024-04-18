package com.example.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/basic")
public class BasicController {
    @GetMapping("/text-basic")
    public String basic(Model model) {
        model.addAttribute("data", "Hello");
        return "basic/text-basic";
    }
}
