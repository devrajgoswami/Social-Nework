<%-- 
    Document   : userHome
    Created on : Aug 18, 2011, 7:59:29 PM
    Author     : Devraj
--%>
<%@page import="com.app.vo.ProDetailsVO"%>
<%@page import="com.app.vo.PersonalDetailsVO"%>
<%@page import="com.app.vo.ContactDetailsVO"%>
<%@page import="com.app.vo.MiniDetailsVO"%>
<%@page import="com.app.vo.ActivityVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.app.dao.service.DAOService"%>
<%@page import="com.app.dao.UserDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="../WEB-INF/ErrorPages/ExceptionPage.jsp" %>
<%@taglib prefix="html" uri="/WEB-INF/struts-html.tld" %>
<!DOCTYPE html>
<html>
        
        <%
        if(request.getParameter("user")==null){
            request.getRequestDispatcher("/profile.do?user="+session.getAttribute("userNO")).forward(request, response);
            //response.sendRedirect("/profile.do?user="+session.getAttribute("userNO"));
            return;
        }%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="images/icon.png" />
        <title><%= DAOService.getUserDAO().getName(Integer.valueOf(request.getParameter("user")))+"'s Page"%></title>
        <link type="text/css" rel="stylesheet" href="CSS/CommonStyle.css" />
  <link href="CSS/facebox.css" media="screen" rel="stylesheet" type="text/css" />
  <script src="JavaScript/jquery.js" type="text/javascript"></script>
  <script src="JavaScript/facebox.js" type="text/javascript"></script>
  <script type="text/javascript">
    jQuery(document).ready(function($) {
      $('a[rel*=facebox]').facebox({
        loadingImage : 'images/loading.gif',
        closeImage   : 'images/closelabel.png'
      })
    })
  </script>
                
    </head>
    <body>
        <%!String url="./Pics/";%>
        <div id="mast">
            <div id="logo" style="text-align:center;border:0px;"><img src="./images/logo.jpg" style="width:198px;height:45px;border-width:1px;border-style:ridge;" /></div>
            <div id="search">
                <form action="./search.do" method="get" >
                    <input type="text" name="search" id="searchBox" /><input type="submit" value="Search" id="searchButton" />
                </form>
            </div>
            <div id="navigator">
                <div id="test">
                    <script type="text/javascript" src="JavaScript/QuickMenu.js"></script>
                    <div id="qm0" class="qmmc"  style="border-width:0px;">
                    <a href="#">
                        <%= DAOService.getUserDAO().getName((Integer)session.getAttribute("userNO"))%>!
                        <img src='images/down.png' width='10' height='11' alt='down.png' border='0' />
                    </a>
                        <div style="border-width:0px;">
                        <a href="./home.do"><img src='images/blank.gif' width='0' height='0' alt='blank.gif' border='0'  />News</a>
                        <a href="./profile.do"><img src='images/blank.gif' width='0' height='0' alt='blank.gif' border='0'  />Profile</a>
                        <a href="./account.do"><img src='images/blank.gif' width='0' height='0' alt='blank.gif' border='0'  />Account</a>
                        <span class="qmdivider qmdividerx"></span>
                        <a href="./Logout.do"><img src='images/blank.gif' width='0' height='0' alt='blank.gif' border='0'  />Logout</a>
                    </div>
                    <span class="qmclear"> </span>
                    </div>
                    <script type="text/javascript">qm_create(0, false, 0, 250, false, false, false, false, false);</script>
                </div>
                <a href="#">Pix</a>
                <a href="./home.do">Home</a>
            </div>
        </div>
        <div id="container">
            <div id="left">
                <div id="profilePic" style="text-align:center;">
                    <%
                        String name=DAOService.getUserDAO().getProfilePic(Integer.valueOf(request.getParameter("user")));
                        if(name!=null)
                            out.println("<img src='"+url+name+"' width='195px' />");
                        else
                            out.println("Picture");
                    %>
                </div>
                <%if(!(DAOService.getUserDAO().isFriend((Integer)session.getAttribute("userNO"),Integer.valueOf(request.getParameter("user"))))){%>
                <div id="addFriend" style="text-align:center;"><%="<a href='./addFriend.do?user="+request.getParameter("user")+"' rel='facebox'><button style='width:150px;'>Add As Friend</button></a>"%></div>
                <%}%>
                <div id="details" style="text-align:center;">
                    <%
                        MiniDetailsVO vo=DAOService.getUserDAO().getMiniDetails(Integer.valueOf(request.getParameter("user")));
                   %>
                    <table style="width:180px;padding:2px;margin-left:20px;">
                        <tr >
                            <td colspan="2"><h4 style="text-transform:capitalize;text-decoration:underline;">User Details</h4></td>
                        </tr>
                        <tr >
                            <td style="text-align:left;">Gender</td><td style="text-align:left;">: <%=vo.getGender()%></td>
                        </tr>
                        <tr>
                            <td style="text-align:left;">Age</td><td style="text-align:left;">: <%=vo.getAge()%></td>
                        </tr>
                        <tr>
                            <td style="text-align:left;">D-O-B</td><td style="text-align:left;">: <%=vo.getDate()+" - "+vo.getMonth()%></td>
                        </tr>
                    </table>
                </div>
            </div>
            <div id="content">
                <div id="fullName">
                    <%=DAOService.getUserDAO().getFullName(Integer.valueOf(request.getParameter("user")))%>
                </div>
                
            <fieldset style="margin:5px;border-color:#000000;">
                <legend style="text-decoration:underline;font-size:large;">Contact Details</legend>
                <div style="height:auto;width:100%;margin:0px;border-width:0px;">
                 <%
                        ContactDetailsVO cvo=DAOService.getUserDAO().getContactDetails(Integer.valueOf(request.getParameter("user")));
                %><table style="width:400px;margin:5px;margin-left:30px;" cellpadding="5px;">
                        <%if(cvo.getMobile()!=null){%>
                        <tr >
                            <td style="text-align:left;">Mobile</td><td style="text-align:left;"> <%="<input type='text' id='detailData' disabled='true' value='"+cvo.getMobile()+"' />"%></td>
                        </tr>
                        <%
                        }if(cvo.getCity()!=null){
                        %>
                        <tr >
                            <td style="text-align:left;">City</td><td style="text-align:left;"> <%="<input type='text' id='detailData' disabled='true' value='"+cvo.getCity()+"' />"%></td>
                        </tr>
                        <%
                        }if(cvo.getState()!=null){
                        %>
                        <tr>
                            <td style="text-align:left;">State</td><td style="text-align:left;"> <%="<input type='text' id='detailData' disabled='true' value='"+cvo.getState()+"' />"%></td>
                        </tr>
                        <%
                        }if(cvo.getCountry()!=null){
                        %>
                        <tr>
                            <td style="text-align:left;">Country</td><td style="text-align:left;"> <%="<input type='text' id='detailData' disabled='true' value='"+cvo.getCountry()+"' />"%></td>
                        </tr>
                        <%}%>
                    </table>
                </div>
            </fieldset>
            <fieldset style="margin:5px;border-color:#000000;">
                <legend style="text-decoration:underline;font-size:large;">Personal Details</legend>
                
                <div style="height:auto;width:100%;margin:0px;border-width:0px;">
                 <%
                        PersonalDetailsVO pvo=DAOService.getUserDAO().getPersonalDetails(Integer.valueOf(request.getParameter("user")));
                 %><table style="width:400px;margin:5px;margin-left:30px;" cellpadding="5px;">
                        <%if(pvo.getAboutMe()!=null){%>
                        <tr >
                            <td style="text-align:left;">About Me</td><td style="text-align:left;"> <%="<input type='text' id='detailData' disabled='true' value='"+pvo.getAboutMe()+"' />"%></td>
                        </tr>
                        <%
                        }if(pvo.getFavMovie()!=null){
                        %>
                        <tr >
                            <td style="text-align:left;">Favorite Movie</td><td style="text-align:left;"> <%="<input type='text' id='detailData' disabled='true' value='"+pvo.getFavMovie()+"' />"%></td>
                        </tr>
                        <%
                        }if(pvo.getFavMusic()!=null){
                        %>
                        <tr>
                            <td style="text-align:left;">Favorite Music</td><td style="text-align:left;"> <%="<input type='text' id='detailData' disabled='true' value='"+pvo.getFavMusic()+"' />"%></td>
                        </tr>
                        <%
                        }if(pvo.getFavBook()!=null){
                        %>
                        <tr>
                            <td style="text-align:left;">Favorite Book</td><td style="text-align:left;"> <%="<input type='text' id='detailData' disabled='true' value='"+pvo.getFavBook()+"' />"%></td>
                        </tr>
                        <%
                        }if(pvo.getFavQuote()!=null){
                        %>
                        <tr>
                            <td style="text-align:left;">Favorite Quote</td><td style="text-align:left;"> <%="<input type='text' id='detailData' disabled='true' value='"+pvo.getFavQuote()+"' />"%></td>
                        </tr>
                        <%
                        }if(pvo.getFavCuisine()!=null){
                        %>
                        <tr>
                            <td style="text-align:left;">Favorite Cuisine</td><td style="text-align:left;"> <%="<input type='text' id='detailData' disabled='true' value='"+pvo.getFavCuisine()+"' />"%></td>
                        </tr>
                        <%}%>
                    </table>    
                </div>
            </fieldset>
            <fieldset style="margin:5px;border-color:#000000;">
                <legend style="text-decoration:underline;font-size:large;">Professional Details</legend>
                
                <div style="height:auto;width:100%;margin:0px;border-width:0px;">
                 <%
                        ProDetailsVO rvo=DAOService.getUserDAO().getProfessionalDetails(Integer.valueOf(request.getParameter("user")));
                 %><table style="width:400px;margin:5px;margin-left:30px;" cellpadding="5px;">
                        <%if(rvo.getSchool()!=null){%>
                        <tr >
                            <td style="text-align:left;">School</td><td style="text-align:left;"> <%="<input type='text' id='detailData' disabled='true' value='"+rvo.getSchool()+"' />"%></td>
                        </tr>
                        <%}if(rvo.getCollege()!=null){%>
                        <tr >
                            <td style="text-align:left;">College</td><td style="text-align:left;"> <%="<input type='text' id='detailData' disabled='true' value='"+rvo.getCollege()+"' />"%></td>
                        </tr>
                        <%}if(rvo.getDegree()!=null){%>
                        <tr >
                            <td style="text-align:left;">Degree</td><td style="text-align:left;"> <%="<input type='text' id='detailData' disabled='true' value='"+rvo.getDegree()+"' />"%></td>
                        </tr>
                        <%}if(rvo.getOccupation()!=null){%>
                        <tr >
                            <td style="text-align:left;">School</td><td style="text-align:left;"> <%="<input type='text' id='detailData' disabled='true' value='"+rvo.getOccupation()+"' />"%></td>
                        </tr>
                        <%}%>
                    </table>    
                </div>
            </fieldset>
            </div>
            <div id="right">
                <div id="friendList">
                    <%="<a href='./friendList.do?user="+request.getParameter("user")+"' rel='facebox'>"%><div id="friendHeader">Friend List</div></a>
                    <%
                        ArrayList<Integer> friends = DAOService.getUserDAO().getFriendMainList(Integer.valueOf(request.getParameter("user")));
                        int count=0;
                        for(Integer i:friends){%>
                        <div class="friend" style="text-align:center;font-size:small;"><%="<a href='./profile.do?user="+i+"' >"%><%= "<img src='"+url+DAOService.getUserDAO().getProfilePic(i)+"' width='90px' height='90px' alt='ankur' />" %> <%=DAOService.getUserDAO().getName(i)%></a> </div>
                            <%
                            count++;
                        }
                        for(;count<9;count++){%>
                            <div class="friend"></div>
                     <%
                        }
                     %>
                </div>
            </div>
        </div>
    </body>
</html>
