package web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletContextDemo2")
public class ServletContextDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /*
       获取MIME类型:

        - 在互联网通信过程中定义的一种文件数据类型
                - 格式:大类型/小类型 text/html  image/jpeg
                - 获取:String getMimeType(String file)
       */
   //  1. 通过HtpServlet获取
        ServletContext servletContext = this.getServletContext();
   //  2. 定义文件名称
        String s = "a.jpg";
        String filename = s;
   //  3.获取mime类型
        String mimeType = servletContext.getMimeType(filename);
        System.out.println(mimeType);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
