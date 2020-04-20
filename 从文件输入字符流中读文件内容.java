package 多线程;

import java.io.*;
import java.util.Scanner;

public class 从文件输入字符流中读文件内容 {
    public static void main(String[] args) throws IOException {
        try (InputStream is = new FileInputStream("我的.txt")) {
            try (Reader reader = new InputStreamReader(is, "UTF-8")) {
                try (Scanner scanner = new Scanner(reader)) {
                    while (scanner.hasNext()) {
                        System.out.println(scanner.next());
                    }
                }
            }
        }
    }
}
