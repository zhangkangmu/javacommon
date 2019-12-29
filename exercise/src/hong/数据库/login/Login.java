package hong.数据库.login;

import hong.数据库.day01.ZYHJDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by zhangyuhong
 * Date:2019/12/26
 */
public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名！");
        String inputName = scanner.next();
        System.out.println("请输入密码！");
        String inputPassword = scanner.next();

        try {
            if (login(inputName, inputPassword)){
                System.out.println("存在该用户");
            }else {
                System.out.println("不存在该用户");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static boolean login(String inputName, String inputPassword) throws SQLException {
        if (inputName == null || inputPassword == null) {
            return false;
        }
        Connection connection = ZYHJDBCUtils.getConnection();
        String sql = "select * from loginmessage where name =? and password=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,inputName);
        preparedStatement.setString(2,inputPassword);
        ResultSet resultSet = preparedStatement.executeQuery();

        return resultSet.next();
    }
}
