package day02_response和request.response._04demo2_download;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * 提供文件下载功能
 * @author liuyp
 * @date 201/01/16
 */
@WebServlet(urlPatterns="/day02/download")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();

        //1.获取客户端提交的参数filename：是要下载的文件名称
        String filename = request.getParameter("filename");

        //response.setContentType("text/html;charset=utf-8");

        //如果客户端要下载a.jpg，给客户端文件名称“沙滩美女.jpg”
        //==增加代码：设置响应头Content-Disposition，告诉浏览器，如何处理给客户端返回的数据
        if ("a.jpg".equals(filename)) {
            /**
             * 下载文件时，中文文件名称乱码：编码和解码方式不一致
             *      编码：response使用iso-8859-1 (响应头)
             *      解码：浏览器使用不一定哪种方式
             * 解决问题：
             *      不能设置响应头的字符集
             *
             *      服务端：
             *      沙滩美女.jpg -->xxxx.jpg -------返回客户端-------> xxxx.jpg -->还原成：沙滩美女.jpg
             *
             *      服务端 把“沙滩美女.jpg”进行转换的方式
             *      客户端 把“xxxx.jpg”   进行还原的方式：这种方式是浏览器内置写死的
             *      以上两种方式必须相同
             *
             *      我们在服务端，需要按照浏览器的还原方式，进行转换
             */

            response.setHeader("Content-Disposition","attachment;filename=" + DownloadUtils.encodeFilename(request, "沙滩美女.jpg"));
        }else{
            response.setHeader("Content-Disposition","attachment;filename=" + filename);
        }

        //2.获取字节型输出流
        ServletOutputStream os = response.getOutputStream();
        //3.获取文件的输入流
        InputStream is = context.getResourceAsStream("WEB-INF/files/" + filename);
        //4.读取数据，通过输出流 输出
        int len = -1;
        byte[] buffer = new byte[1024 * 8];
        while ((len = is.read(buffer)) != -1) {
            os.write(buffer, 0, len);
        }
        is.close();
        os.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}