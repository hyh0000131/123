package com.huang.swagger.controller;

import com.huang.swagger.pojo.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Cucumber
 * @Description
 * @Date Created in 2021-04-06 10:34
 */
//Operation接口
@ApiOperation("Hello控制类")
@RestController
public class HelloController {

    @GetMapping(value = "/hello")
    public String hello(){
        return "hello";
    }

    //只要接口的返回值中存在实体类，就会被扫描到Swagger中
    @PostMapping(value = "/user")
    public User user(){
        return new User();
    }

}
