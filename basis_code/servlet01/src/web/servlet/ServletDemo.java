package web.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/demo")
public class ServletDemo implements Servlet{
    /*
        servlet的init方法只执行一次,说明一个servlet在内存中只存在一个对象,servlet是单例的
            多个用户同时访问时可能会出现线程安全的问题
            解决:尽量不要在servelt中定义成员变量,即使定义了成员变量也不要对其修改值
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        System.out.println("Servlet 3.0来了!!!");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
