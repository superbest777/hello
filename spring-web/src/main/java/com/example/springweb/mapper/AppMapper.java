package com.example.springweb.mapper;

import com.example.springweb.dao.App;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AppMapper {
    @Select("select * from appinfo")
    List<App>find_all();

    @Select("select * from appinfo where is_checked=false")
    List<App>precheck();

    @Select("select * from appinfo where id = #{id}")
    App getByID(String id);

    @Select("select * from appinfo where name = #{name}")
    App getByName(String name);

    @Update("update appinfo set name=#{name},class_1=#{class_1},class_2=#{class_2},class_3=#{class_3},grade_1=#{grade_1},grade_2=#{grade_2},grade_7=#{grade_7},grade = #{grade},is_checked=1 where id = #{id}")
    void updateByID(String name,String class_1,String class_2,String class_3,String grade_1,String grade_2,String grade_7,String grade,String id);
}
