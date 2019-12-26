package com.example.springweb.dao;

import java.io.Serializable;

public class App implements Serializable {
    private String id;
    private String name;
    private String date;
    private String Security_level;
    private String class_1;
    private String class_2;
    private String class_3;
    private String grade_1;
    private String grade_2;
    private String grade_7;
    private String grade;
    private boolean is_checked;

    public String getId(){return  id;}
    public String getName(){return name;}
    public String getDate(){return date;}
    public String getSecurity_level(){ return Security_level; }
    public String getClass_1(){return class_1;}
    public String getClass_2(){return class_2;}
    public String getClass_3(){return class_3;}
    public String getGrade_1(){return grade_1;}
    public String getGrade_2(){return grade_2;}
    public String getGrade_7(){return grade_7;}
    public String getGrade(){return grade;}


}
