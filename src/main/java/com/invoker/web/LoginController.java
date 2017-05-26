package com.invoker.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2017/5/25 at 23:57
 */
@Controller
public class LoginController {
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login(){
        return "index" ;
    }
}
