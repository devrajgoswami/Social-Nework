
package com.app.action;

import com.app.beans.LoginForm;
import com.app.dao.UserDAO;
import com.app.dao.service.DAOService;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class LoginUser extends org.apache.struts.action.Action {

    private static String page = "failure";
    private static final Logger logger=Logger.getLogger(LoginUser.class.getName());

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        UserDAO userDAO = DAOService.getUserDAO();
        LoginForm loginForm = (LoginForm)form;
        if(userDAO.loginUser(loginForm.getUserID(),loginForm.getPassword()))
        {
            Integer userNO = new Integer(userDAO.getUserNo(loginForm.getUserID()));
            request.getSession().setAttribute("userNO",userNO);
            logger.info("Logged in as "+userNO);
            response.sendRedirect("./home.do");
        }else{
            request.setAttribute("loginFailure", true);
            return mapping.findForward(page);
        }
        return mapping.findForward(null);
    }
}
