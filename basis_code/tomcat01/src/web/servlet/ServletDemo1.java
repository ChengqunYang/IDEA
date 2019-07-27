package web.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * Servlet的快速入门
 * tomcat部署项目的方式:
 *      1.直接将项目放到webapps目录下即可
 *          1.1 /hello:项目的访问路径-->虚拟路径
 *          1.2 简化部署:将项目打成一个war包,在京war包放置到webappps目录下.war包会自动解压缩
 *      2.配置conf/server.xml文件
 *          在<Host>标签体中配置
 *          <Context docBase="D:\hello" path="/hehe" />
 *              docbase:项目存放的路径
 *              path:虚拟目录
 *      3.在conf\catalina\localhost创建任意名称的xml文件,在文件中编写
 *          <Context docBase="D:\hello" />
 *              虚拟目录:xml文件的名称
 *          热部署:修改完配置文件后并不需要重启服务器即可生效
 * 静态项目和动态项目:
 *  1. 目录结构:
 *      1.1 java动态项目的目录结构:
 *          -- 项目的根目录
 *              -- WEB-INF目录
 *                  --web.xml:web项目的核心配置文件
 *                  --classes目录:放置字节码文件的目录
 *                  --lib目录:放置依赖的jar包
 *
 */
public class ServletDemo1 implements Servlet{
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("HelloServlet");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
