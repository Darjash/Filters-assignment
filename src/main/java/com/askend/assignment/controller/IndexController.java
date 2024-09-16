package com.askend.assignment.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController implements ErrorController {
    @RequestMapping(value = "/{path:[^\\.]*}")
    public String redirect() {
        return "forward:/index.html";
    }
    @RequestMapping(value = "${server.error.path:${error.path:/error}}")
    public String error() {
        return "forward:/index.html";
    }
}