package com.example.arthricare.bean;

import java.math.BigDecimal;

public class User {
    private Long id;
    private String name;
    private int age;
    private String gender;
    private BigDecimal weight;
    private String email;
    private String password;

    // 默认构造函数
    public User() {}
    // 带参数的构造函数
    public User(String name, int age, String gender, BigDecimal weight, String email, String password) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.weight = weight;
        this.email = email;
        this.password = password;
    }
    // Getter 和 Setter 方法
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", weight=" + weight +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

