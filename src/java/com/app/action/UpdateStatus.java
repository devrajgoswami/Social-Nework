
package com.app.action;

import com.app.beans.StatusUpdateForm;
import com.app.dao.service.DAOService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Devraj
 */
public class UpdateStatus extends org.apache.struts.action.Action {

    private static final String SUCCESS = "success";

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        StatusUpdateForm form1 = (StatusUpdateForm)form;
        String userNo=""+request.getSession().getAttribute("userNO");
        DAOService.getUserDAO().updateStatus(Integer.valueOf(userNo), form1.getMood());
        form1.setMood("");
        response.sendRedirect("./home.do");
        return mapping.findForward(null);
    }
}
