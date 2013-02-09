
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="WEB-INF/ErrorPages/ExceptionPage.jsp" %>
<%@page import="java.sql.*" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="html" uri="/WEB-INF/struts-html.tld" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registration Successful!!!</h1>
        <h2><%=request.getAttribute("name")%></h2>
        
        <%
            String url="./Pics/";
            String dumb=null;
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/social","root","root" );
                Statement st=con.createStatement();
                ResultSet rs=st.executeQuery("select * from pic;");
                if(rs.next())
                    dumb = rs.getString("filename");
                    //out.println(dumb);
            }
            catch(ClassNotFoundException ex){
                out.println(ex);
            }
            catch(SQLException ex){
                out.println(ex);
            }
            url=url+dumb;
        %>
        <br />
        <br />
        <%=url%>
        <br />
        <br />
        <br />
        <%----
        <img src="<%=url%>" width="200" height="200"  alt="Profile Pic" />
        --%>
        <div>
            <html:img src="<%=url%>" alt="Profile Pic" style="height:200px;width:200px;" />
        </div>
        <a href="./hack.do">Hacker</a>
    </body>
</html>
