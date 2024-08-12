package com.example.demo.controller;

import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ConfigCheckController {
    private final Environment environment;

    @GetMapping("/v1/config")
    public String getConfig() {
        String applicationName = environment.getProperty("spring.application.name");
        String serverPort = environment.getProperty("server.port");
        return "Application Name: " + applicationName + ", Server Port: " + serverPort;
    }
}
