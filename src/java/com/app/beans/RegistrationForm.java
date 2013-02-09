/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.beans;

import java.util.ArrayList;
import java.util.Collection;
import org.apache.struts.util.LabelValueBean;



public class RegistrationForm extends org.apache.struts.action.ActionForm {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String rePassword;
    private String selectedSex;
    private Collection<LabelValueBean> sex;
    private String dob;

    public RegistrationForm() {
        sex=new ArrayList<LabelValueBean>();
        sex.add(new LabelValueBean("--Select One--", "-1"));
        sex.add(new LabelValueBean("Male", "Male"));
        sex.add(new LabelValueBean("Female", "Female"));
    }
    
    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    public String getSelectedSex() {
        return selectedSex;
    }

    public void setSelectedSex(String selectedSex) {
        this.selectedSex = selectedSex;
    }

    public Collection<LabelValueBean> getSex() {
        return sex;
    }

    public void setSex(Collection<LabelValueBean> sex) {
        this.sex = sex;
    }
    
    
    
//    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
//        ActionErrors errors = new ActionErrors();
//        if (getName() == null || getName().length() < 1) {
//            errors.add("name", new ActionMessage("error.name.required"));
//            // TODO: add 'error.name.required' key to your resources
//        }
//        return errors;
//    }

}
