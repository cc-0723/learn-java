package 练习;

import java.util.Arrays;

public class Base {
    Base() {
        System.out.print("Base");
    }

    public static class Alpha extends Base {
        public static void main(String[] args) {
            new Alpha();
            new Base();
        }
    }
}

