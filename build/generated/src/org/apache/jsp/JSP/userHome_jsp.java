package org.apache.jsp.JSP;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.app.dao.service.DAOService;
import com.app.dao.UserDAO;

public final class userHome_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

String url="./Pics/";
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"../WEB-INF/ErrorPages/ExceptionPage.jsp", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>JSP Page</title>\r\n");
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" href=\"CSS/CommonStyle.css\" />\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("        <div id=\"mast\">\r\n");
      out.write("            <div id=\"logo\" style=\"text-align:center;\">LOGO</div>\r\n");
      out.write("            <div id=\"search\">\r\n");
      out.write("                <form action=\"#\" method=\"get\">\r\n");
      out.write("                    <input type=\"text\" name=\"search\" id=\"searchBox\" /><input type=\"submit\" value=\"Search\" id=\"searchButton\" />\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div id=\"navigator\">\r\n");
      out.write("                <a href=\"#\">");
      out.print( DAOService.getUserDAO().getFullName((Integer)request.getAttribute("userNO")));
      out.write("!</a>\r\n");
      out.write("                <a href=\"#\">Pix</a>\r\n");
      out.write("                <a href=\"#\">Home</a>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div id=\"container\">\r\n");
      out.write("            <div id=\"left\">\r\n");
      out.write("                <div id=\"profilePic\" style=\"text-align:center;\">\r\n");
      out.write("                    ");

                        String name=DAOService.getUserDAO().getProfilePic((Integer)request.getAttribute("userNO"));
                        if(name!=null)
                            out.println("<img src='"+url+name+"' width='195px' />");
                        else
                            out.println("Picture");
                    
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("                <div id=\"details\" style=\"text-align:center;\">Details</div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div id=\"content\">\r\n");
      out.write("                <div id=\"status\" style=\"text-align:center;\">Ur Mood's Gonna Be Here!!!</div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div id=\"right\">\r\n");
      out.write("                <div id=\"friendList\">\r\n");
      out.write("                    <div id=\"friendHeader\">Friend List</div>\r\n");
      out.write("                    <div class=\"friend\" style=\"text-align:center;font-size:small;\"><img src=\"Pics/file1.jpg\" width=\"90px\" height=\"90px\" alt=\"ankur\" />Ankur Jha</div>\r\n");
      out.write("                    <div class=\"friend\"></div>\r\n");
      out.write("                    <div class=\"friend\"></div>\r\n");
      out.write("                    <div class=\"friend\"></div>\r\n");
      out.write("                    <div class=\"friend\"></div>\r\n");
      out.write("                    <div class=\"friend\"></div>\r\n");
      out.write("                    <div class=\"friend\"></div>\r\n");
      out.write("                    <div class=\"friend\"></div>\r\n");
      out.write("                    <div class=\"friend\"></div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
