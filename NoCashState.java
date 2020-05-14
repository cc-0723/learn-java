package 设计模式实验;

public class NoCashState implements ATMState{
    private ATM atm;//保留状态持有者的引用，以便对其进行操作

    public NoCashState(ATM atm){
        this.atm = atm;
    }

    @Override
    public void insertCard() {
        System.out.println("插卡完成");
    }

    @Override
    public void submitPwd() {
        System.out.println("密码提交完成");
        //验证密码并做相应处理
        if("123".equals(atm.getPwd())){
            System.out.println("密码验证通过");
        }
        else{
            System.out.println("密码验证失败");
            //弹出卡片
            ejectCard();
        }
    }

    @Override
    public void getCash() {
        System.out.println("取款失败，机器内无钞");
    }

    @Override
    public void queryBalance() {
        System.out.println("账户余额￥" + atm.getBalance());
        System.out.println("账户余额查询完成");
    }

    @Override
    public void ejectCard() {
        System.out.println("取卡完成");
    }
}
