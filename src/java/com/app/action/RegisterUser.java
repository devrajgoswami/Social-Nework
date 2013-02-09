
package com.app.action;

import com.app.beans.RegistrationForm;
import com.app.dao.UserDAO;
import com.app.dao.service.DAOService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class RegisterUser extends org.apache.struts.action.Action {

    private static final String SUCCESS = "success";

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception{
        RegistrationForm form1 = (RegistrationForm)form;
        UserDAO userDAO = DAOService.getUserDAO();
        int userNO=0;
        if(form1.getPassword().equals(form1.getRePassword()))
            userNO=userDAO.registerUser(form1.getFirstName(),form1.getLastName(),form1.getEmail(),form1.getPassword(),form1.getSelectedSex(),form1.getDob());
        if(userNO>0)
        {
            request.getSession().setAttribute("userNO",userNO);
            response.sendRedirect("./home.do");
        }
        else
            response.sendRedirect("./");
        return mapping.findForward(null);
    }
}
