/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.vo;

/**
 *
 * @author Devraj
 */
public class ProDetailsVO {
    String school,college,degree,occupation;

    public ProDetailsVO(String school, String college, String degree, String occupation) {
        this.school = school;
        this.college = college;
        this.degree = degree;
        this.occupation = occupation;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
    
}
