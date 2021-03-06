package web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RequestDemo5")
public class RequestDemo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo5被访问了......");
    //转发到demo9资源
     /*   RequestDispatcher requestDispatcher = request.getRequestDispatcher("/RequestDemo6");
        requestDispatcher.forward(request,response);*/
     //存储数据到request域中
        request.setAttribute("msg","hello");

     request.getRequestDispatcher("/RequestDemo6").forward(request,response);
//     response.sendRedirect("");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request, response);
    }
}
