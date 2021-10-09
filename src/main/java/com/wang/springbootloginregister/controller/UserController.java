package com.wang.springbootloginregister.controller;

import com.wang.springbootloginregister.pojo.User;
import com.wang.springbootloginregister.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 注册账号
     *
     * @param user
     * @return
     */
    @PostMapping("create")
    public Map<String, Object> createAccount(User user){
        return userService.createAccount(user);
    }

    /**
     * 登录账号
     *
     * @param user
     * @return
     */
    @PostMapping("login")
    public Map<String, Object> loginAccount(User user){
        return userService.loginAccount(user);
    }

    /**
     *
     *
     * @param confirmCode
     * @return
     */
    @GetMapping("activation")
    public Map<String, Object> activationAccount(String confirmCode){
        return userService.activationAccount(confirmCode);
    }

}
