package web.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ResponseDemo1")
public class ResponseDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println(response);

        System.out.println("demo1被访问了");
        //访问/responseDemo1,会自动跳转到/responseDemo2资源
       /* //1.设置状态码:302
        response.setStatus(302);
        //2.设置响应头location
        response.setHeader("location","/servlet01/ResponseDemo2");
*/
        //简单的重定向方法
        response.sendRedirect("/servlet01/ResponseDemo2");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request, response);
    }
}
