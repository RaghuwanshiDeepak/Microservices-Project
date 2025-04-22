package com.microservices.Students_Management.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testing")
public class ApiGatewayTesting {

    @GetMapping
    public String apiGatewaysTesting(){
        return "Successfully tested";
    }
}