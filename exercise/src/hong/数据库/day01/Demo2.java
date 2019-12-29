package hong.数据库.day01;

import hong.数据库.day01.bean.Student;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by zhangyuhong
 * Date:2019/12/24
 * 封装bean和配置文件，以及utils公工具类
 */
public class Demo2 {

    private static Connection connection = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        try {
            connection = ZYHJDBCUtils.getConnection();

            String sql = "select * from students";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");

                Student student = new Student();
                student.setAge(id);
                student.setName(name);
                student.setAge(age);
                students.add(student);
            }
            System.out.println(students);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ZYHJDBCUtils.close(resultSet, preparedStatement, connection);
        }
    }
}
