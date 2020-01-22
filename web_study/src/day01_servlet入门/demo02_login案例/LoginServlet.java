package day01_servlet入门.demo02_login案例;

import day00_utils.C3P0JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 登录校验功能Servlet
 * 需要导入的jar包：
 *      1. 数据库驱动包
 *      2. 连接池的包：c3p0。 配置文件：c3p0-config.xml
 *      3. DBUtils的包
 */
@WebServlet(urlPatterns="/day01/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收客户端提交的表单参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //2.登录校验：校验用户名和密码是否正确。执行SQL语句 SELECT * FROM user where username = ? and password = ?
        QueryRunner runner = new QueryRunner(C3P0JdbcUtils.getDataSource());
        String sql = "SELECT * FROM user where username = ? and password = ?";
        User user = null;
        try {
            user = runner.query(sql, new BeanHandler<>(User.class), username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //3.处理结果：
        if (user != null) {
            //如果user不为空，说明登录成功。给客户端返回：login success
            response.getWriter().print("login success");
        }else{
            //登录失败。给客户端返回：login failed
            response.getWriter().print("login failed");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
