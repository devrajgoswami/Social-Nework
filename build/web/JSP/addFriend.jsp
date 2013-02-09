<%-- 
    Document   : addFriend
    Created on : Oct 18, 2011, 2:18:09 PM
    Author     : Devraj
--%>

<%@page import="com.app.dao.service.DAOService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Friend</title>
    </head>
    <body>
        <%
        if(DAOService.getUserDAO().isFriendRequested((Integer)session.getAttribute("userNO"),(Integer.valueOf(request.getParameter("user"))))){
            %>
            <h3 style="text-align:center;">Friend Request already sent.</h3>
            <h3 style="text-align:center;">Please wait for user response.</h3>
            <%
        }else{
        %>
        <%="<form action='./friendRequest.do?requestFor="+request.getParameter("user")+"' method='post'>"%>
        <table style="width:100%">
            <tr>
                <td colspan="2">
            <h3 style="text-align:center;">Add <%=DAOService.getUserDAO().getFullName(Integer.valueOf(request.getParameter("user")))%> as your friend?</h3>
            <span style="text-align:left;">Send a personal message:</span>
            </td>
            </tr>
            <tr>
                <td colspan="2">
                    <textarea name="message" style="overflow:auto;resize:none;width:100%"/>
                </td>
            </tr>
            <tr>
                <td><input type="submit" value="Confirm" style="width:100%;height:30px;" /></td>
                <td><%="<a href='./profile.do?user="+request.getParameter("user")+"'>"%><button style="width:100%;height:30px;">Cancel</button></a></td>
            </tr>
        </table>
        </form>
        <%
        }
        %>
    </body>
</html>
