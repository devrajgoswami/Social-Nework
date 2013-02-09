<%-- 
    Document   : friendList
    Created on : Oct 19, 2011, 3:12:28 AM
    Author     : Devraj
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.app.dao.service.DAOService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css">
           
            p:hover{
                text-decoration:underline;
            }
        </style>
    </head>
    <body>
        <%
            ArrayList<Integer> list=DAOService.getUserDAO().getFullFriendList(Integer.parseInt(request.getParameter("user")));
            for(int i:list){
        %>
        <div style="width:450px;height:90px;margin:5px;border-width:2px;border-style:solid;">
            <%="<img src='./Pics/"+DAOService.getUserDAO().getProfilePic(i)+"' style='width:90px;height:90px;float:left;margin-right:10px' />"%><%="<a href='./profile.do?user="+i+"'>"%><p style="color:#000000;"><%=DAOService.getUserDAO().getFullName(i)%></p></a>
        </div>
        <%
           }
        %>
    </body>
</html>
