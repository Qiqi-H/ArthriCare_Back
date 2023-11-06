package com.example.arthricare.bean;

import java.math.BigDecimal;


public class User {
    private int userId;
    private String name;
    private int age;
    private String gender;
    private double weight;
    private String email;
    private String password;
    private int point;
    private int height;
    private String weightUnit;
    private String heightUnit;


    // 默认构造函数
    public User() {}
    // 带参数的构造函数
    public User(String name, int age, String gender, double weight, String email, String password) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.weight = weight;
        this.email = email;
        this.password = password;
        point = 0;
    }
    // Getter 和 Setter 方法


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPoint() {
        return point;
    }
    public void setPoint(int point) {
        this.point = this.point+point;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(String weightUnit) {
        this.weightUnit = weightUnit;
    }

    public String getHeightUnit() {
        return heightUnit;
    }

    public void setHeightUnit(String heightUnit) {
        this.heightUnit = heightUnit;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", weight=" + weight +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", point=" + point +
                ", height=" + height +
                '}';
    }
}

