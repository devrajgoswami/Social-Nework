<%-- 
    Document   : userHome
    Created on : Aug 18, 2011, 7:59:29 PM
    Author     : Devraj
--%>
<%@page import="com.app.vo.FriendRequestVO"%>
<%@page import="com.app.vo.ActivityVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.app.dao.service.DAOService"%>
<%@page import="com.app.dao.UserDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="../WEB-INF/ErrorPages/ExceptionPage.jsp" %>
<%@taglib prefix="html" uri="/WEB-INF/struts-html.tld" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="images/icon.png" />
        <title><%= DAOService.getUserDAO().getName((Integer)session.getAttribute("userNO"))+"'s Page"%></title>
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
                    <a href="#" style="border-color:#000000;border-width:2px;">
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
<!--                <a href="./home.do">Home</a>-->
                <html:link page="/home.do">Home</html:link>
            </div>
        </div>
        <div id="container">
            <div id="left">
                <div id="profilePic" style="text-align:center;">
                    <%
                        String name=DAOService.getUserDAO().getProfilePic((Integer)session.getAttribute("userNO"));
                        if(name!=null)
                            out.println("<img src='"+url+name+"' width='195px' />");
                        else
                            out.println("Picture");
                    %>
                </div>
                <div id="details" style="text-align:center;">Details</div>
            </div>
            <div id="content">
                
                
            </div>
            <div id="right">
                <div id="friendList">
                    <%="<a href='./friendList.do?user="+(Integer)session.getAttribute("userNO")+"' rel='facebox'>"%><div id="friendHeader">Friend List</div></a>
                    <%
                        ArrayList<Integer> friends = DAOService.getUserDAO().getFriendMainList((Integer)session.getAttribute("userNO"));
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
                <br/>
                <div id="friendRequest">
                    <div id="friendHeader" style="text-align:center;">Friend Requests</div>
                <%
                    ArrayList<FriendRequestVO> list = DAOService.getUserDAO().getFriendRequest((Integer)session.getAttribute("userNO"));
                    for(FriendRequestVO friend:list){
                    %>
                    <div class="requests">
                        <%= "<img src='"+url+DAOService.getUserDAO().getProfilePic(friend.getRequestBy())+"' style='width:90px;height:90px;float:left;margin-right:10px;' />" %>
                        <h4 style="margin:1px;vertical-align:top;margin-top:0px;"><%="<a href='./profile.do?user="+friend.getRequestBy()+"' >"+friend.getRequestByName()+"</a>"%></h4>
                        <div style="border-width:1px;border-style:solid;margin:2px;font-size:small;"><%=friend.getMessage()%></div>
                        <div style="border-width:0px;float:right;vertical-align:bottom;">
                        <table style="width:190px;margin-bottom:2px;">
                            <tr>
                                <td><%="<a href='./acceptFriend.do?requestNo="+friend.getRequestNo()+"' >"%><button style="width:100%;">Accept</button></a></td>
                                <td><%="<a href='./rejectFriend.do?requestNo="+friend.getRequestNo()+"' >"%><button style="width:100%;">Reject</button></a></td>
                            </tr>
                        </table>
                        </div>
                    </div>
                    <%
                    }
                %>
                </div>
            </div>
        </div>
    </body>
</html>
