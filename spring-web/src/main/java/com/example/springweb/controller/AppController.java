package com.example.springweb.controller;

import com.example.springweb.dao.App;
import com.example.springweb.service.AppService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AppController {
    @Autowired
    AppService appService;
    public final static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping(value = "/checkApp")
    public ModelAndView checkApp(@RequestParam(value="id")String id,ModelAndView mv){
        mv.setViewName("checkApp");
        App app = appService.getByID(id);

        mv.addObject("app",app);
        return mv;
    }

    @RequestMapping(value="/refer")
    public ModelAndView refer(ModelAndView mv, @RequestParam(value="id")String id, @RequestParam("c1")String class_1
    , @RequestParam("class_2")String class_2, @RequestParam("class_3")String class_3
            , @RequestParam("name")String name, @RequestParam("grade_1")String grade_1
    , @RequestParam("grade_2")String grade_2, @RequestParam("grade_7")String grade_7
    , @RequestParam("grade")String grade,HttpServletRequest request){

        logger.info("logging"+id+name);
        appService.updateByID(name,class_1,class_2,class_3,grade_1,grade_2,grade_7,grade, id);
        mv.setViewName("redirect:/list");

        return mv;
    }

}
