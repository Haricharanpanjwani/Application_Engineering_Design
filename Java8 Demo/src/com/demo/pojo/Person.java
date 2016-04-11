package com.demo.pojo;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hpanjwani
 */
public class Person {
    
    String name;
    int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age =age;
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
    
    public String toString() {
        return "Name:" + this.name + "\nAge : " + this.age;
    }
    
}
