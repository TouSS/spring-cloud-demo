package com.xx.demo.consumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/consumer/ribbon")
public class RibbonController {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/addAB")
    public Integer addAB(Integer a, Integer b) {
        String url = "http://PROVIDER/compute/add?a={a}&b={b}";
        Map<String, Integer> uriVariables = new HashMap<>();
        uriVariables.put("a", a);
        uriVariables.put("b", b);
        return restTemplate.getForObject(url, Integer.class, uriVariables);
    }

    @GetMapping("/divideAB")
    @HystrixCommand(fallbackMethod = "divideABFallback")
    public Integer divideAB(Integer a, Integer b) {
        String url = "http://PROVIDER/compute/divide?a={a}&b={b}";
        Map<String, Integer> uriVariables = new HashMap<>();
        uriVariables.put("a", a);
        uriVariables.put("b", b);
        return restTemplate.getForObject(url, Integer.class, uriVariables);
    }

    public Integer divideABFallback(Integer a, Integer b) {
        return -1;
    }

}
