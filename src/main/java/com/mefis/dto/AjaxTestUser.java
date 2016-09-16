package com.mefis.dto;

import com.mefis.controller.MainController;

/**
 * Created by Lion on 9/5/16.
 */
public class AjaxTestUser {

    private String name;
    private String surname;
    private int age;
    private int checkTime;

    public AjaxTestUser() {
    }

    public AjaxTestUser(String name, String surname, int age, int checkTime) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.checkTime = checkTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(int checkTime) {
        this.checkTime = checkTime;
    }

    public static int generateCheckTime() {
        return MainController.random.nextInt(10) + 15;
    }
}
