package day04_jsp_el_jstl._01servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author liuyp
 * @date 2020/02/08
 */
@WebServlet(urlPatterns="/jsp/demo01")
public class Demo01Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Servlet能否显示一些内容到浏览器上？可以
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("<h1>Servlet显示的内容</h1>");

        for (int i = 0; i < 10; i++) {

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}