package com.example.springweb;

import com.example.springweb.dao.HelloUser;
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
public class HelloServiceTest {
    @Autowired
    HelloService helloService;

    @Test
    public void getUsers() {
        List<HelloUser> users = helloService.getUserList();
        assertFalse("User not null", users == null);
        assertNotNull(users);
        assertNotEquals(users.size(), 0);
        assertEquals(users.get(0).getName(), "pony");
    }

    @Test
    public void testInsert1() throws Exception{
        //helloService.InsertUser(new HelloUser("4","zyy","dsb"));
        // assertEquals(helloService.getUserList().size(),3);
        Map<String,String> params=new HashMap<>();
        params.put("id","00004");
        params.put("name","niha");
        params.put("password","yes");
        helloService.InsertUser(params);
        assertEquals(helloService.getUserList().size(),3);
    }

    @Test
    public void testInsert2() throws Exception{
        //helloService.InsertUser(new HelloUser("4","zyy","dsb"));
        // assertEquals(helloService.getUserList().size(),3);
        Map<String,String> params=new HashMap<>();
        params.put("id","00005");
        params.put("name","11");
        params.put("password","");
        helloService.InsertUser(params);
        assertEquals(helloService.getUserList().size(),4);
    }

    @Test
    public void testInsert3() throws Exception{
        //helloService.InsertUser(new HelloUser("4","zyy","dsb"));
        // assertEquals(helloService.getUserList().size(),3);
        Map<String,String> params=new HashMap<>();
        params.put("id","");
        params.put("name","11");
        params.put("password","");
        helloService.InsertUser(params);
        assertEquals(helloService.getUserList().size(),5);
    }

    public void testInsert4() throws Exception{
        //helloService.InsertUser(new HelloUser("4","zyy","dsb"));
        // assertEquals(helloService.getUserList().size(),3);
        Map<String,String> params=new HashMap<>();
        params.put("id","00004");
        params.put("name","11");
        params.put("password","");
        helloService.InsertUser(params);
        assertEquals(helloService.getUserList().size(),6);
    }

    public void testInsert5() throws Exception{
        //helloService.InsertUser(new HelloUser("4","zyy","dsb"));
        // assertEquals(helloService.getUserList().size(),3);
        Map<String,String> params=new HashMap<>();
        params.put("id","00010");
        params.put("name","1111111111111111111111111111111111");
        params.put("password","");
        helloService.InsertUser(params);
        assertEquals(helloService.getUserList().size(),7);
    }

    @Test
    public void testGetOne1() throws Exception{
        HelloUser helloUser = helloService.getOne("00001");
        assertEquals(helloUser.getName(),"pony");
    }

    @Test
    public void testGetOne2() throws Exception{
        HelloUser helloUser = helloService.getOne("00007");
        assertEquals(helloUser.getName(),null);
    }

    @Test
    public void testUpdate1() throws Exception{
        // helloService.UpdateByID(new HelloUser("3","ooo","bbbb"));
        // assertEquals(helloService.getOne("3").getName(),"ooo");
        Map<String,String> params=new HashMap<>();
        params.put("id","4");
        params.put("name","xxx");
        helloService.UpdateByID(params);
        assertEquals(helloService.getOne("4").getName(),"xxx");
    }

    @Test
    public void testUpdate2() throws Exception{
        // helloService.UpdateByID(new HelloUser("3","ooo","bbbb"));
        // assertEquals(helloService.getOne("3").getName(),"ooo");
        Map<String,String> params=new HashMap<>();
        params.put("id","04");
        params.put("name","zzz");
        helloService.UpdateByID(params);
        assertEquals(helloService.getOne("4").getName(),"xxx");
    }

    @Test
    public void testUpdate3() throws Exception{
        // helloService.UpdateByID(new HelloUser("3","ooo","bbbb"));
        // assertEquals(helloService.getOne("3").getName(),"ooo");
        Map<String,String> params=new HashMap<>();
        params.put("id","4");
        params.put("name","zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
        helloService.UpdateByID(params);
        assertEquals(helloService.getOne("4").getName(),"zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
    }

    @Test
    public void testDelete1() throws Exception{
        helloService.DeleteByID("4");
        assertEquals(helloService.getOne("4").getName(),null);
    }

    @Test
    public void testDelete2() throws Exception{
        helloService.DeleteByID("000000");
        assertEquals(helloService.getOne("000000").getName(),null);
    }
}
