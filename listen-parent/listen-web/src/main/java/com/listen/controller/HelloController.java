package com.listen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Exler
 */
@Controller
public class HelloController {

    @RequestMapping("index")
    public String index() {
        return "login";
    }

    @RequestMapping("/{role}/home")
    public String index(@PathVariable String role) {
        return role + "/home";
    }
}