package 多线程;

import java.io.File;
import java.util.Scanner;

public class MakeDirectory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        File file = new File("cc");
        System.out.println("对象创建成功");
        scanner.nextLine();
        file.mkdir();
        System.out.println("文件夹创建成功");
        scanner.nextLine();
        delete();
        System.out.println("文件夹删除成功");
        scanner.nextLine();
    }

    public static void delete() {
        File file = new File("cc");
        file.delete();
    }
}