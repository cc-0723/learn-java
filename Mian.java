package 数据库;

import java.sql.*;
import java.util.Scanner;

public class Mian {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/2020_3_1?useSSL=false&characterEncoding=utf8";
        String user = "root";
        String password = "";
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);

        //从Scanner中不停的读取SQL，并执行
        Scanner scanner = new Scanner(System.in);
            while(true) {
                System.out.print("mysql> ");
                String sql = scanner.nextLine();
                if(sql.equals("quit")) {
                    break;
                }
                //创建一个Statement语句
                Statement statement = connection.createStatement();
                //执行
                if(sql.startsWith("seclect")) {
                    ResultSet rs = statement.executeQuery(sql);
                    int columnCount = rs.getMetaData().getColumnCount();
                    while(rs.next()) {
                        for(int i = 1; i <= columnCount; i++) {
                            String result = rs.getString(i);
                            System.out.print(result + " ");
                        }
                        System.out.println();
                    }
                    rs.close();
                } else {
                    int n = statement.executeUpdate(sql);
                    System.out.printf("%d行受到影响%n", n);
                }
                statement.close();
            }

        //关闭连接
        connection.close();
    }
}
