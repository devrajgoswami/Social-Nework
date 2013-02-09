<%-- 
    Document   : acceptFriend
    Created on : Oct 18, 2011, 7:43:24 PM
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
        DAOService.getUserDAO().acceptFriendRequest(Integer.valueOf(request.getParameter("requestNo")));
        response.sendRedirect("./home.do");
    %>
    </body>
</html>
