/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.beans;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author Devraj
 */
public class StatusUpdateForm extends org.apache.struts.action.ActionForm {
    
    String mood;
    
    public StatusUpdateForm() {
        super();
        // TODO Auto-generated constructor stub
    }
    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    /**
     * This is the action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
//     }
}
