package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * Cookie快速入门
 */
@WebServlet("/CookieDemo3")
public class CookieDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 创建Cookie对象
        Cookie cookie = new Cookie("msg","setMaxAge");
        //2.设置Cookie的存活时间
        //cookie.setMaxAge(30);//将Cookie持久化到磁盘,30秒后会自动删除cookie文件
        //cookie.setMaxAge(-1);//浏览器关闭,Cookie销毁
        cookie.setMaxAge(0);//在整数时间未结束前删除Cookie信息
        //3.发送Cookie
        response.addCookie(cookie);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
