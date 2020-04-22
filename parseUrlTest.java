package Socket编程;

import java.util.HashMap;
import java.util.Map;

public class parseUrlTest {
    public static void main(String[] args) {
        String[] url = {
                "http://www.bitedu.vip/thread-809.htm",
                "http://www.bitedu.vip/thread-809.htm?query=peixinchen",
                "https://www.bitedu.vip/thread-809.htm?query=peixinchen",
                "https://www.bitedu.vip:8080/thread-809.htm?query=peixinchen",
                "jdbc:mysql://127.0.0.1/java14_blog?useSSL=false&characterEncoding=utf8"
        };

        for(String s : url) {
            parseUrl(s);
            System.out.println("-----------------------------------------------");
        }
    }

    private static Map<String, Integer> standardPort = new HashMap<>();
    static {
        standardPort.put("ssh", 22);
        standardPort.put("http", 80);
        standardPort.put("https", 443);
        standardPort.put("jdbc:mysql", 3306);
    }

    private static void parseUrl(String url) {
        System.out.println(url);
        System.out.println();

        //1.找出://之前部分
        int i = url.indexOf("://");
        String schema = url.substring(0, i);
        System.out.println("协议部分：" + schema);
        String rest = url.substring(i + 3);

        //2.找出主机部分
        i = rest.indexOf("/");
        String host = rest.substring(0, i);
        rest = rest.substring(i);

        //3.将端口号分离
        String[] fragments = host.split(":");
        String Ip;;
        int port;
        if(fragments.length == 1) {
            //没有端口
            Ip = host;
            port = standardPort.get(schema);
        } else {
            //主机有端口
            Ip = fragments[0];
            port = Integer.parseInt(fragments[1]);
        }
        System.out.println("域名：" + Ip);
        System.out.println("端口号：" + port);

        //4.分离出 path 和 queryString 部分
        String path;
        String queryString;
        i = rest.indexOf("?");
        if(i == -1) {
            path = rest;
            queryString = " ";
        } else {
            path = rest.substring(0, i);
            queryString = rest.substring(i + 1);
        }
        System.out.println("path: " + path);
        System.out.println("queryString：" + queryString);
    }
}
