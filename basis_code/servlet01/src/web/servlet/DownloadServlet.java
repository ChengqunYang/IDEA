package web.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 文件下载需求:
 *  1.页面显示超链接
 *  2.点击超链接后弹出下载提示框
 *  3.完成图片文件下载
 *
 *  分析:
 *      1.超链接指向的资源如果能够被浏览器解析,则在浏览器中展示,如果不能解析,则弹出下载提示框,不满足要求
 *      2.任何资源都必须弹出下载提示框
 *      3.使用响应头设置资源的打开方式:
 *          content=disposition:attachment;filename-xx
 *
 *  步骤:
 *      1.定义页面,边界超链接的href属性,指向servlet,传递资源名称filename
 *      2.定义Servlet
 *          1.获取文件名称
 *          2.使用字节输入流加载文件进内存
 *          3.指定response的响应头:content-disposition:attachment;filename-xxx
 *          4.将数据写出到response输出流
 *
 *  问题:
 *      中文文件名问题:
 *          解决思路:
 *              1.获取客户端使用的浏览器版本信息
 *              2.根据不同的版本信息,设置filename的编码方式不同
 */
@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //1.获取文件名称
        String filename = request.getParameter("filename");
    //2.使用字节输入流加载文件进内存
        //2.1找到文件的服务器路径
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/img/" + filename);
        //2.2用字节流关联
        FileInputStream fis = new FileInputStream(realPath);
    //3.指定response的响应头:content-disposition:attachment;filename-xxx
        //3.1设置响应头类型:content-type
        String mimeType = servletContext.getMimeType(filename);
        response.setHeader("content-type",mimeType);
        //3.2设置响应头打开方式:content-disposition
        response.setHeader("content-disposition","attachment;filename="+filename);
        //4.将数据写出到response输出流
        ServletOutputStream sos = response.getOutputStream();
        byte[] buff = new byte[1024*8];
        int len = 0;
        while ((len = fis.read(buff))!= -1){
            sos.write(buff,0,len);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }
}
