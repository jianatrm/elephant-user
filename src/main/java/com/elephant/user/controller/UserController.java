package com.elephant.user.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/getUserInfo")
    @ResponseBody
    public Object getUserInfo(@AuthenticationPrincipal String username){
        return username;
    }
}
