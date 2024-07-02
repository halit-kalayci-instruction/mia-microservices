package com.example.service_two.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/base")
public class BaseController {

    @Value("${pod.name}")
    private String podName;

    @Value("${pod.ip}")
    private String podIp;

    @GetMapping()
    public String greetFromOne(@RequestParam(name = "name") String name) throws InterruptedException {
        Thread.sleep(3000);
        return "Pod: " + podName + ", IP: " + podIp;
    }
}
