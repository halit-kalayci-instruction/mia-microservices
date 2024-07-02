package com.example.service_one.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.service_one.clients.ServiceTwoClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/base")
public class BaseController {

    private final ServiceTwoClient serviceTwoClient;

    @Value("${pod.name}")
    private String podName;

    @Value("${pod.ip}")
    private String podIp;

    public BaseController(ServiceTwoClient serviceTwoClient) {
        this.serviceTwoClient = serviceTwoClient;
    }

    @GetMapping("")
    public String getMethodName() {

        String name = this.serviceTwoClient.greet("Halit");

        return "Pod: " + podName + ", IP: " + podIp + " - Received message from other service:" + name;
    }

    @GetMapping("pod")
    public String getPodDetails() {
        return "Pod: " + podName + ", IP: " + podIp;
    }

}
