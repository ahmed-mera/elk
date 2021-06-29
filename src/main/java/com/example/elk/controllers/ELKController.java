package com.example.elk.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@Slf4j
public class ELKController {

    @RequestMapping(value = "/elk")
    public String helloWorld() {
        String response = "Welcome to Java ELK" + new Date();
        log.info("response : {}", response);

        return response;
    }

    @RequestMapping(value = "/exception")
    public String exception() {
        String response = "";
        try {
            throw new Exception("Exception has occurred....");
        } catch (Exception e) {
            log.error("error: {}", e.getMessage());
            log.error("Exception - " , e);
        }
        return response;
    }
}
