package com.xx.demo.provider.controller;

import com.xx.demo.provider.bean.ErrorCode;
import com.xx.demo.provider.exception.CallingException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(value="/compute", tags="简单计算接口")
@RestController
@RequestMapping("/compute")
public class ComputeController {

    @ApiOperation("加法")
    @GetMapping("/add")
    public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
        return a + b;
    }

    @ApiOperation("减法")
    @GetMapping("/minus")
    public Integer minus(Integer a, Integer b) {
        return a - b;
    }

    @ApiOperation("乘法")
    @GetMapping("/multiply")
    public Integer multiply(Integer a, Integer b) {
        return a * b;
    }

    @ApiOperation("除法")
    @GetMapping("/divide")
    public Integer divide(Integer a, Integer b) {
        if(b == 0) {
            throw new CallingException(ErrorCode.DIVISOR_NOT_BE_ZERO);
        }
        return a / b;
    }
}
