package com.xx.demo.consumer.controller;

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
@RequestMapping("/consumer/without")
public class WithoutController {
    /**
     * 使用负载均衡器来手动获取服务提供者，也可以使用ribbon通过注解的方式来自动负载均衡 注解：@LoadBalanced
     */
    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/addAB")
    public Integer addAB(Integer a, Integer b) {
        ServiceInstance serviceInstance =loadBalancerClient.choose("Provider");
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/compute/add?a={a}&b={b}";
        Map<String, Integer> uriVariables = new HashMap<>();
        uriVariables.put("a", a);
        uriVariables.put("b", b);
        return restTemplate.getForObject(url, Integer.class, uriVariables);
    }

    @GetMapping("/divideAB")
    public Integer divideAB(Integer a, Integer b) {
        ServiceInstance serviceInstance =loadBalancerClient.choose("Provider");
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/compute/divide?a={a}&b={b}";
        Map<String, Integer> uriVariables = new HashMap<>();
        uriVariables.put("a", a);
        uriVariables.put("b", b);
        return restTemplate.getForObject(url, Integer.class, uriVariables);
    }

}
