package 数据库;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class 连接池 {
    private static DataSource dataSource;

    public static void main(String[] args) {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setServerName("127.0.0.1");
        mysqlDataSource.setPort(3306);
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("");
        mysqlDataSource.setDatabaseName("cc_db");
        mysqlDataSource.setCharacterEncoding("utf8");
        mysqlDataSource.setUseSSL(false);

        dataSource = mysqlDataSource;

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("请输入要查找的姓名> ");
            String name = scanner.nextLine();

            findStudent(name);
        }
        
    }

    private static void findStudent(String name) {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "SELECT id, name, class_name FROM students WHERE name = ?";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {

                // 把占位符进行替换
                statement.setString(1, name);
                try (ResultSet rs = statement.executeQuery()) {
                    while (rs.next()) {
                        System.out.println(rs.getString(1));
                        System.out.println(rs.getString(2));
                        System.out.println(rs.getString(3));
                    }
                    System.out.println("=====================");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
