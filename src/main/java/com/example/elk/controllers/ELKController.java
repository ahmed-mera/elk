package com.example.elk.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

@RestController
@Slf4j
public class ELKController {

    @Autowired
    RestTemplate restTemplate;

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

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
            e.printStackTrace();
            log.error("error: {}", e.getMessage());

            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            String stackTrace = sw.toString();
            log.error("Exception - " + stackTrace);
            response = stackTrace;
        }

        return response;
    }
}
