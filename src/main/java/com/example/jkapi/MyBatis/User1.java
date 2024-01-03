package com.example.jkapi.MyBatis;

public class User1 {

    private int id;  //id
    private String name;   //姓名
    private String workcode;   //密码

    public User1(){

    }
    public User1(int id, String name, String workcode) {
        this.id = id;
        this.name = name;
        this.workcode = workcode;
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

    public String getworkcode() {
        return workcode;
    }

    public void setworkcode(String workcode) {
        this.workcode = workcode;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", workcode='" + workcode + '\'' +
                '}';
    }
}

