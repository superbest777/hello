package com.example.springweb.service;

import com.example.springweb.dao.App;
import com.example.springweb.mapper.AppMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class AppService {
    @Resource
    private AppMapper appMapper;

    public List<App> getAppList(){
        List<App> list = appMapper.find_all();
        return list;
    }

    public List<App> getpreList(){
        List<App> list = appMapper.precheck();
        return list;
    }

    public App getByID(String id){
        App result = appMapper.getByID(id);
        return result;
    }

    public String getSecurity_level(String id){
        App app = appMapper.getByID(id);
        return app.getSecurity_level();
    }

    public void updateByID(String name,String class_1,String class_2,String class_3,String grade_1,String grade_2,String grade_7,String grade,String id){
        appMapper.updateByID(name,class_1,class_2,class_3,grade_1,grade_2,grade_7,grade, id);
    }


}
