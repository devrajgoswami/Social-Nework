
package com.app.beans;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


public class LoginForm extends org.apache.struts.action.ActionForm {
    
    private String userID;
    private String password;
    
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
    
    
    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if (getUserID() == null || getUserID().length() < 4 || getUserID().length() > 45 || getPassword() == null || getPassword().length() < 6|| getPassword().length() > 30){
            errors.add("userID", new ActionMessage("error.name.required"));
        }
        return errors;
    }
}
