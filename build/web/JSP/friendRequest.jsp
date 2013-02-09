<%-- 
    Document   : friendRequest
    Created on : Oct 18, 2011, 5:28:53 PM
    Author     : Devraj
--%>

<%@page import="com.app.dao.service.DAOService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            DAOService.getUserDAO().addFriendRequest(Integer.parseInt(request.getParameter("requestFor")),(Integer)session.getAttribute("userNO"),request.getParameter("message"));
            response.sendRedirect("./profile.do?user="+request.getParameter("requestFor"));
        %>
    </body>
</html>
