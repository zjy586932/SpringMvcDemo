package com.spring.mvc.controller.entity;

public class JsonParam{
    String name;
    String pass;

    public JsonParam() {
    }

    public JsonParam(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "JsonParam{" +
                "name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}