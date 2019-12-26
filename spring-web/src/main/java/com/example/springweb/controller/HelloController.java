package com.example.springweb.controller;

import com.example.springweb.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {
    @Autowired
    HelloService helloService;
    public final static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping(value = "/hello")
    public String hello(){
        logger.info("hello logging" + helloService.getUserList());

        return "hello";
    }
}
