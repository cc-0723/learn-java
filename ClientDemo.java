package 设计模式实验;

public class ClientDemo {
    public static void main(String[] args) {
        try {
            test(800, 500, 200, "2580");
            System.out.println("============================================================");
            test(2000, 300, 1200, "2580");
            System.out.println("============================================================");
            test(-2000, 500, 300, "2580");
        } catch (Exception e) {
            System.out.println("账户余额小于-1000，账户状态为红色透支状态，请存钱后再取");
        }
    }

    private static void test(int totalAmount, int balance, int amount, String pwd)throws Exception{
        //创建ATM
         ATM atm;
         atm = new ATM(totalAmount, balance, amount, pwd);
         //输出初始状态
         System.out.println(atm.toString());
         System.out.println(atm.SKT());
         atm.insertCard();
         atm.submitPwd();
         atm.getCash();        //输出结束状态
         System.out.println(atm.toString());
         }
    }
