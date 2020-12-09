package com.sleepy.zeo.stream.message;

import java.io.Serializable;

public class UserMessage implements Serializable {

    private static final long serialVersionUID = -2151657164946262117L;

    private String name;
    private int age;

    public UserMessage() {
    }

    public UserMessage(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserMessage[" +
                "name='" + name + '\'' +
                ", age=" + age +
                ']';
    }
}
