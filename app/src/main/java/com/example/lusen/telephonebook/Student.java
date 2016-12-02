package com.example.lusen.telephonebook;

/**
 * Created by lusen on 2016/11/29.
 */

public class Student {
    private String name;
    private String num;
    Student(String name,String num){
        this.name=name;
        this.num=num;
    }
    public String getname(){
        return name;
    }
    public String getNum(){
        return num;
    }
}
