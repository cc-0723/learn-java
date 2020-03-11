package 数据库;

import java.sql.*;
import java.util.Scanner;

public class MyTest {
    private static String ip;
    private static int port;
    private static String user;
    private static String password;
    private static String defaultDatabase;

    private static void parseArgs(String[] args) {
        ip = args[0].substring(2);
        port = Integer.parseInt(args[1].substring(2));
        user = args[2].substring(2);
        defaultDatabase = args[4];
        System.out.print("Enter password: ");
        Scanner scanner = new Scanner(System.in);
        password = scanner.nextLine();

        System.out.println(ip);
        System.out.println(port);
        System.out.println(user);
        System.out.println(password);
        System.out.println(defaultDatabase);
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        parseArgs(args);

        //注册 Driver
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/2020_3_1?useSSL=false&characterEncoding=utf8";
        Connection connection = DriverManager.getConnection(url, "root","");

        //System.out.println(connection);
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()) {
            String sql = scanner.nextLine();
            if(sql.trim().isEmpty()) {
                continue;
            }
            if(sql.equalsIgnoreCase("quit")) {
                break;
            }
            Statement statement = connection.createStatement();

            String firstWord = sql.split(" ")[0];
            if(firstWord.equalsIgnoreCase("select") || firstWord.equalsIgnoreCase("show")
            || firstWord.equalsIgnoreCase("desc")) {
                executeSQLWithResult(statement, sql);
            } else {
                executeSQLWithoutResult(statement, sql);
            }
            statement.close();
        }

        //关闭
        connection.close();
    }

    private static void executeSQLWithoutResult(Statement statement, String sql) throws SQLException {
        int 受到影响的行数 = statement.executeUpdate(sql);
        System.out.println("受到影响的行数" + 受到影响的行数);
    }

    private static void executeSQLWithResult(Statement statement, String sql) throws SQLException {
        ResultSet rs = statement.executeQuery(sql);

        //取到结果集元信息
        ResultSetMetaData meteData = rs.getMetaData();
        int columnCount = meteData.getColumnCount();

        for(int i =0; i < columnCount; i++) {
            String columnName = meteData.getColumnName(i + 1);
            System.out.print(columnName + " ");
        }
        System.out.println();

        while(rs.next()) {
            for(int i = 0; i < columnCount; i++) {
                String value = rs.getString(i + 1);
                System.out.print(value + " ");
            }
            System.out.println();
        }
        rs.close();
    }
}
