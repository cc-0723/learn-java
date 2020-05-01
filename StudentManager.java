package 数据库;

import java.sql.*;

public class StudentManager {
    //简单查询课程
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/studentmanager?useSSL=false&characterEncoding=utf8";
        Connection connection = DriverManager.getConnection(url, "root", "");

        {
            String sql = "select class_id from schedules where begin_at between '2020-03-01 00:00:00' and '2020-03-02 00:00:00'";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()) {
                System.out.println(rs.getInt("class_id"));
            }
            rs.close();
            statement.close();
        }

        connection.close();
    }
}
