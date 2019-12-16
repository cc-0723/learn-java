package String;

import java.util.ArrayList;

public class TryCatchException {
    public static void main(String[] args) throws Exception {
        try{
            new ArrayList().get(0);
        } catch (RuntimeException e) {
            throw new MyException("我的异常",e);
        } finally {
            throw new Exception("我是必须要执行的");
        }
    }
}
