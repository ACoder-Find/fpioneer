package com.benpencil.fpioneer.passport.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.benpencil.fpioneer.bean.Result;
import com.benpencil.fpioneer.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class PassportController {

    @Reference
    UserService userService;

    @GetMapping("user/loginOrRegister")
    @ResponseBody
    public Result result(HttpServletRequest req, HttpServletResponse resp){

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Result result = userService.getResult(username , password);

        return result ;
    }

}
