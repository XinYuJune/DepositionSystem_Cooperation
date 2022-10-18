package src;

public class Deposition {
    double currentbalance = 0;
    String userName = "1班彭俊";
    int account = 20224924;

    public double getCurrentBalance() {
        return currentbalance;
    }

    public String getUserName() {
        return userName;
    }

    public int getAccount() {
        return account;
    }

    public void setCurrentbalance(double currentbalance) {
        if (currentbalance > 0) {
            this.currentbalance += currentbalance;
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