package com.example.springweb.controller;

import com.example.springweb.dao.App;
import com.example.springweb.dao.HelloUser;
import com.example.springweb.service.AppService;
import com.example.springweb.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    HelloService helloService;

    @Autowired
    AppService appService;

    @RequestMapping(value = "/list")
    public ModelAndView login(ModelAndView mv) {
        mv.setViewName("list");
        List<App>listPre=appService.getpreList();
        mv.addObject("listPre",listPre);
        return mv;
    }

    @RequestMapping(value = "/index")
    public ModelAndView index(ModelAndView mv) {
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping(value = "/submit")
    public ModelAndView submit(@RequestParam(value = "username") String username,
                               @RequestParam(value = "password") String password, HttpServletRequest request, ModelAndView mv) {
        HttpSession session = request.getSession();

        HelloUser c=helloService.getOne(username);
        if(c==null){
            mv.setViewName("index");
            mv.addObject("name","登录失败,请检查用户名密码");
        }

        else if(c.getPassword().equals(password)){
            session.setAttribute("loginUser", username);
            mv.setViewName("list");
            List<App>listPre=appService.getpreList();
            mv.addObject("listPre",listPre);
        }else{
            mv.setViewName("index");
            mv.addObject("name","登录失败,请检查用户名密码");
        }
        return mv;
    }


}
