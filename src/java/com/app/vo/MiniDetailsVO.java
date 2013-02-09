
package com.app.vo;

/**
 *
 * @author Devraj
 */
public class MiniDetailsVO {
    String gender;
    int age;
    int date;
    String month;
    String email;

    public MiniDetailsVO(String gender, int age, int date, String month, String email) {
        this.gender = gender;
        this.age = age;
        this.date = date;
        this.month = month;
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
}
