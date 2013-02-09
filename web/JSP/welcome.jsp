<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page errorPage="WEB-INF/ErrorPages/ExceptionPage.jsp" %>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html lang="true">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="../images/icon.png" />
        <title><bean:message key="welcome.title"/></title>
        <html:base/>
        <link type="text/css" rel="stylesheet" href="../CSS/FormStyle.css" />
        <link type="text/css" rel="stylesheet" href="../CSS/CommonStyle.css" />
    </head>
    <body id="bod">
        <html:javascript formName="LoginForm"/>
        <div align="right">
            <div id="logo" style="text-align:center;border:0px;"><img src="../images/logo.jpg" style="width:400px;height:95px;border-width:1px;border-style:ridge;float:left;" /></div>
            <html:form method="post" action="/LoginUser.do" onsubmit="validateLoginForm(this)">
                <table>
                    <thead>
                        <tr>
                            <th colspan="3" style="text-align:center;background-color:yellowgreen;text-transform:uppercase;font-size:large;color:darkred;"> <bean:message key="login.form.title"/></th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td align="left"><bean:message key="login.form.userID"/></td>
                            <td align="left"><bean:message key="login.form.password"/></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td><html:text property="userID" styleClass="loginFormField" /></td>
                            <td><html:password property="password" styleClass="loginFormField" /></td>
                            <td><html:submit styleClass="loginFormButton"><bean:message key="login.form.submit"/></html:submit></td>
                        </tr>
                        <%
                        if(request.getAttribute("loginFailure")!=null){
                        %>
                        <tr>
                            <td colspan="3" style="color:#FF0000;text-align:center;">Invalid User ID / Password.</td>
                        </tr><%}%>
                    </tbody>
                </table>
            </html:form>
        </div>
        
        <div align="right">
            <html:form method="post" action="/RegisterUser.do">
                <table cellpadding="2">
                    <thead>
                        <tr>
                            <th colspan="2" style="text-align:center;background-color:yellowgreen;text-transform:uppercase;font-size:large;color:darkred;" >
                                <bean:message key="welcome.form.title"/>
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td align="right"><bean:message key="welcome.form.firstName"/></td>
                            <td><html:text property="firstName" styleClass="registerFormField" /></td>
                        </tr>
                        <tr>
                            <td align="right"><bean:message key="welcome.form.lastName"/></td>
                            <td><html:text property="lastName" styleClass="registerFormField" /></td>
                        </tr>
                        <tr>
                            <td align="right"><bean:message key="welcome.form.email"/></td>
                            <td><html:text property="email" styleClass="registerFormField" /></td>
                        </tr>
                        <tr>
                            <td align="right"><bean:message key="welcome.form.Password"/></td>
                            <td><html:password property="password" styleClass="registerFormField" /></td>
                        </tr>
                        <tr>
                            <td align="right"><bean:message key="welcome.form.RePassword"/></td>
                            <td><html:password property="rePassword" styleClass="registerFormField" /></td>
                        </tr>
                        <tr>
                            <td align="right"><bean:message key="welcome.form.sex"/></td>
                            <td>
                                
                                <html:select property="selectedSex" styleClass="registerFormField">
                                    <html:optionsCollection property="sex" />
                                </html:select>
                                
                            </td>
                        </tr>
                        <tr>
                            <td align="right"><bean:message key="welcome.form.dob"/></td>
                            <td><html:text property="dob" styleClass="registerFormField" value="yyyy-mm-dd" onfocus="javascript:if(this.value=='yyyy-mm-dd'){this.value='';}" onblur="javascript:if(this.value==''){this.value='yyyy-mm-dd';}" /></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><html:submit styleClass="registerFormButton"><bean:message key="welcome.form.signup"/></html:submit>&nbsp;&nbsp;<html:reset styleClass="registerFormButton"><bean:message key="welcome.form.reset"/></html:reset></td>
                        </tr>
                    </tbody>
                </table>

            </html:form>
        </div>
    </body>
</html:html>
