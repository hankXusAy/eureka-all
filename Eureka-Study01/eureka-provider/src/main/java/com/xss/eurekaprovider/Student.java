package com.xss.eurekaprovider;

/**
 * @ClassName Student
 * @Description
 * @Author xushaoshuai
 * @Parameters
 * @Date 2020/7/4 4:46 下午
 * @Return
 */
public class Student {
    private int id;
    private String name;

    public Student() {
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
