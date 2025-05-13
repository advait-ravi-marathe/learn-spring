package com.courseIn28Mins.learn_spring;

import java.io.Serializable;

//Pojo - Plain old Java object
class Pojo {
    private String text;

    private int number;

    public String toString(){
        return STR."\{text}:\{number}";
    }
}

class JavaBean implements Serializable {
    //1. Should have public no argument constructor
    public JavaBean() {

    }

    private String text;

    private int number;

    //2. Should have getters and setters
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    //3. Should implement Serializable
}

public class SpringBeanVSJavaBean {

    public static void main(String[] args) {
        Pojo newPojo = new Pojo();

        System.out.println(newPojo);
    }
}
