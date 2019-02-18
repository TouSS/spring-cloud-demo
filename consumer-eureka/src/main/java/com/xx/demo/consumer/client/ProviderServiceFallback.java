package com.xx.demo.consumer.client;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xx.demo.consumer.bean.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
public class ProviderServiceFallback implements ProviderService {
    @Override
    public User addUser(User user) {
        return null;
    }

    @Override
    public User getUser(Integer id) {
        return null;
    }

    @Override
    public User deleteUser(Integer id) {
        return null;
    }

    @Override
    public List<User> query() {
        return null;
    }

    @Override
    public Integer addAB(Integer a, Integer b) {
        return null;
    }

    @Override
    public Integer minusAB(Integer a, Integer b) {
        return null;
    }

    @Override
    public Integer multiplyAB(Integer a, Integer b) {
        return null;
    }

    @Override
    public Integer divideAB(Integer a, Integer b) {
        return -1;
    }
}
