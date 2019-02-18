package com.xx.demo.consumer.controller;

import com.xx.demo.consumer.bean.User;
import com.xx.demo.consumer.client.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/consumer/feign")
public class FeignController {
    @Autowired
    private ProviderService providerService;

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public User addUser(@RequestParam("name") String name, @RequestParam("age") Integer age) {
        return providerService.addUser(new User(name, age));
    }

    @RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable("id") Integer id) {
        return providerService.getUser(id);
    }

    @RequestMapping(value = "/queryUser", method = RequestMethod.GET)
    public List<User> queryUser() {
        return providerService.query();
    }

    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
    public User deleteUser(@PathVariable("id") Integer id) {
        return providerService.deleteUser(id);
    }

    @RequestMapping(value = "/addAB", method = RequestMethod.GET)
    public Integer addAB(@RequestParam("a") Integer a, @RequestParam("b") Integer b) {
        return providerService.addAB(a, b);
    }

    @RequestMapping(value = "/minusAB", method = RequestMethod.GET)
    public Integer minusAB(@RequestParam("a") Integer a, @RequestParam("b") Integer b) {
        return providerService.minusAB(a, b);
    }

    @RequestMapping(value = "/multiplyAB", method = RequestMethod.GET)
    public Integer multiplyAB(@RequestParam("a") Integer a, @RequestParam("b") Integer b) {
        return providerService.multiplyAB(a, b);
    }

    @RequestMapping(value = "/divideAB", method = RequestMethod.GET)
    public Integer divideAB(@RequestParam("a") Integer a, @RequestParam("b") Integer b) {
        return providerService.divideAB(a, b);
    }
}
