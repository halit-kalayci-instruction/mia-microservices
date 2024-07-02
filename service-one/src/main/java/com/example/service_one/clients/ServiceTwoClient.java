package com.example.service_one.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "service-two", url = "${service-two.url}")
public interface ServiceTwoClient {
    @GetMapping("/api/base")
    String greet(@RequestParam(name = "name") String name);
}
