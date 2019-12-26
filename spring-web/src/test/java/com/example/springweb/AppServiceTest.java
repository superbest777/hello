package com.example.springweb;

import com.example.springweb.dao.App;
import com.example.springweb.dao.HelloUser;
import com.example.springweb.service.AppService;
import com.example.springweb.service.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppServiceTest {
    @Autowired
    AppService appService;

    @Test
    public void testgetApplist(){
        List<App> apps = appService.getAppList();
        assertNotEquals(apps.size(),0);
        assertEquals(apps.get(0).getSecurity_level(),"1");
    }

    @Test
    public void testgetprelist(){
        List<App> apps = appService.getpreList();
        assertNotEquals(apps.size(),0);
        assertEquals(apps.get(0).getSecurity_level(),"1");
    }

    @Test
    public void testgetByID1(){
        App app=appService.getByID("1");
        assertEquals(app.getName(),"222");
    }

    @Test
    public void testgetByID2(){
        App app=appService.getByID("3");
        assertEquals(app.getName(),null);
    }

    @Test
    public void testgetsecurity_level1(){
        String s=appService.getSecurity_level("1");
        assertEquals(s,"1");
    }

    @Test
    public void testgetsecurity_level2(){
        String s=appService.getSecurity_level("3");
        assertEquals(s,null);
    }

    @Test
    public void testupdate1(){
        appService.updateByID("111","111","111","111","111","111","111","111","1");
        assertEquals(appService.getByID("1").getName(),"111");
    }

    @Test
    public void testupdate2(){
        appService.updateByID("111","11111111","111","111","111","1111111","111","111","1");
        assertEquals(appService.getByID("1").getName(),"111");
    }

    @Test
    public void testupdate3() {
        appService.updateByID("111", "11111111", "111", "111", "111", "111", "111", "111", "3");
        assertEquals(appService.getByID("3").getName(), "111");
    }
}
