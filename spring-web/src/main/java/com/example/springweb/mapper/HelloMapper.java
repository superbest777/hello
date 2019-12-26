package com.example.springweb.mapper;

import com.example.springweb.dao.HelloUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface HelloMapper {
    @Select("select * from user ")
    @Results({
            @Result(property = "id", column = "stringId"),
            @Result(property = "name", column = "user_name")
    })
    List<HelloUser> findAll();

    @Insert("insert into user(stringId,user_name,password) values(#{id},#{name},#{password})")
    void insert(HelloUser helloUser);


    @Select("select * from user where stringId = #{id}")
    @Results({
            @Result(property = "id",column = "stringId"),
            @Result(property = "name",column = "user_name")
    })
    HelloUser getOne(String id);

    @Select("select * from user where user_name = #{name}")
    @Results({
            @Result(property = "id",column = "stringId"),
            @Result(property = "name",column = "user_name")

    })
    HelloUser getUser(String name);

    @Update("update user set user_name = #{name}, password = #{password} where StringId = #{id}")
    void updateByID(HelloUser helloUser);//UPDATE 表名�SET 列名�= 新�WHERE 列名�= 某�
    @Delete("delete from user where StringId = #{id}")
    void deleteByID(String id);//DELETE FROM 表名�WHERE 列名�= �}
}
