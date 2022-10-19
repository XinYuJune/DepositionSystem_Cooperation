package src.Deposition;

public class Deposition {
    static double currentBalance = 0;
    String userName = "彭俊小組";
    int account = 20224924;

    public double getCurrentBalance() {
        return currentBalance;
    }

    public String getUserName() {
        return userName;
    }

    public int getAccount() {
        return account;
    }

    public void setcurrentBalance(double currentBalance) {
        if (currentBalance > 0) {
            this.currentBalance += currentBalance;
        } else {
            System.out.println("存入金额需大于0！");
        }
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    //设置初始化欢迎语句
    public String getWelcomeMessage() {
        return "嗨，"+getUserName()+"！\n欢迎您使用储蓄业务系统！\n"  + "您的账号为：" + getAccount();
    }

}