package com.xx.demo.provider.controller;

import com.xx.demo.provider.bean.ErrorCode;
import com.xx.demo.provider.bean.Index;
import com.xx.demo.provider.bean.IndexList;
import com.xx.demo.provider.bean.User;
import com.xx.demo.provider.exception.CallingException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value="/user", tags="用户管理接口")
@RestController
@RequestMapping("/user")
public class UserController {
    @ApiOperation(value="添加用户", notes = "添加用户数据")
    @PostMapping("/add")
    public User add(@RequestBody User user) {
        return (User) IndexList.add(user);
    }

    @ApiOperation(value="获取用户", notes = "获取用户数据")
    @GetMapping("/get/{id}")
    public User get(@PathVariable("id") Integer id) {
        User user = (User) IndexList.get(id);
        if(user == null) throw new CallingException(ErrorCode.INFO_NOT_FOUND);
        return user;
    }

    @ApiOperation(value="移除用户", notes = "移除用户数据")
    @GetMapping("/delete/{id}")
    public User delete(@PathVariable("id") Integer id) {
        User user = (User) IndexList.remove(id);
        if(user == null) throw new CallingException(ErrorCode.INFO_NOT_FOUND);
        return user;
    }

    @ApiOperation(value="用户列表", notes = "用户列表")
    @GetMapping("/query")
    public List<Index> query() {
        List<Index> indexes = IndexList.all();
        if(indexes == null && indexes.isEmpty()) throw new CallingException(ErrorCode.INFO_NOT_FOUND);
        return indexes;
    }
}
