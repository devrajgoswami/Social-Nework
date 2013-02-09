/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.vo;

/**
 *
 * @author Devraj
 */
public class ContactDetailsVO {
    
    String mobile,city,state,country;

    public ContactDetailsVO(String mobile, String city, String state, String country) {
        this.mobile = mobile;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
