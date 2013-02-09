<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body style="background-color:cornflowerblue">
        <h1>Sorry Dude!</h1>
        <h2>Some error has occurred.</h2>
        <h3>Technically its: <label style="color:red;"> <%=exception %> </label></h3>
        <%
            response.sendRedirect("./");
        %>
    </body>
</html>
