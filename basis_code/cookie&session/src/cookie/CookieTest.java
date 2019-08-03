package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 在服务器中的Servlet判断,是否有一个名为LastTime的Cookie
 *      1.有,不是第一次访问
 *          响应数据,欢迎回来,您上次访问时间为:2019年7月29日9:12:25
 *          写回Cookie,LastTime=2019年7月29日9:12:54
 *      2.没有,是第一次访问
 *          响应数据,您好,欢迎您首次访问
 *          写回Cookie,LastTime=2019年7月29日9:14:01
 */
@WebServlet("/CookieTest")
public class CookieTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应的消息体的数据格式和编码
        response.setContentType("text/html;charset=utf-8");

        //1.获取所有的Cookie
        Cookie[] cookies = request.getCookies();
        boolean flag = false;//没有一个名为LastTime的Cookie
        //2.遍历cookies数组
        if(cookies != null && cookies.length>0){
            for (Cookie cookie:cookies) {
                //3.获取cookie的名称
                String name = cookie.getName();
                //4.判断名称是否是,LastTime
                if ("LastTime".equals(name)){
                    //有该Cookie,不是第一次访问
                    flag = true;//有LastTime的Cookie

                    //响应数据
                    //获取Cookie的value,时间
                    String value = cookie.getValue();
                    System.out.println("解码前"+value);
                    //URL解码:
                    value = URLDecoder.decode(value,"utf-8");
                    System.out.println("解码后"+value);
                    response.getWriter().write("<h1>欢迎回来,您上次的访问时间为:"+value+"</h1>");

                    //更新Cookie的value
                    //获取当前时间的字符串,重新设置Cookie的值,重新发送Cookie
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String str_date = sdf.format(date);

                    System.out.println("编码前"+str_date);
                    //URL编码
                    str_date = URLEncoder.encode(str_date, "utf-8");
                    System.out.println("编码后"+str_date);
                    cookie.setValue(str_date);
                    //设置Cookie的存活时间
                    cookie.setMaxAge(60*60*24*30);//一个月
                    response.addCookie(cookie);
                    break;
                }
            }
        }
        if (cookies==null || cookies.length == 0 || flag == false){
            //没有,第一次访问

            //设置Cookie的value
            //获取当前时间的字符串,重新设置Cookie的值,重新发送Cookie
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String str_date = sdf.format(date);

            System.out.println("编码前"+str_date);
            //URL编码
            str_date = URLEncoder.encode(str_date, "utf-8");
            System.out.println("编码后"+str_date);

            Cookie cookie = new Cookie("LastTime",str_date);
            //设置Cookie的存活时间
            cookie.setMaxAge(60*60*24*30);//一个月
            response.addCookie(cookie);

            //响应数据
            response.getWriter().write("<h1>您好,欢迎您首次访问</h1>");

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
