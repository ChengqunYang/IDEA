package com.monster.controller;

import com.monster.domain.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 返回值是一个字符串
     *
     * @param model
     * @return
     */
    @RequestMapping("/testString")
    public String testString(Model model) {
        System.out.println("testString方法执行了...");
        //模拟从数据库中查询出User对象
        User user = new User();
        user.setUsername("美美");
        user.setPassword("123");
        user.setAge(30);
        //modle对象
        model.addAttribute("user", user);
        return "success";//视图解析器根据返回的名称寻找相应的jsp页面进行跳转
    }

    /**
     * 返回值是Void
     *
     * @param
     */
    @RequestMapping("/testVoid")
    public void testString(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("testVoid方法执行了...");
        //编写请求转发的程序
        //request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);

        //重定向
        //response.sendRedirect(request.getContextPath()+"/index.jsp");

        //设置中文乱码
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/heml;charset=UTF-8");
        //直接响应
        response.getWriter().print("你好!");
        return;
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        //创建一个ModelAndView对象
        ModelAndView mv = new ModelAndView();
        System.out.println("testModelAndView方法执行了...");
        //模拟从数据库中查询出User对象
        User user = new User();
        user.setUsername("小风");
        user.setPassword("456");
        user.setAge(30);

        //把user对象存储到mv对象中,也会把user对象存入到request对象
        mv.addObject("user", user);
        //跳转到哪个页面
        mv.setViewName("success");
        return mv;
    }

    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect() {
        System.out.println("testForwardOrRedirect执行了...");

        //请求的转发
        //return "forward:/WEB-INF/pages/success.jsp";//视图解析器根据返回的名称寻找相应的jsp页面进行跳转


        //重定向
        return "redirect:/index.jsp";
    }

    /**
     * 模拟异步请求相应
     * @param user
     */
    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user) {
        System.out.println("testAjax执行了...");
        //客户端发送ajax的请求,传的是字符串,后端把json字符串封装到user对象中
        System.out.println(user);
        //做响应,模拟查询数据库
        user.setUsername("haha");
        user.setAge(40);
        //做响应
        return user;
    }
}