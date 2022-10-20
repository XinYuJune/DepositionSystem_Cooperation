package src.Deposition;/*
 *@Author:222401 彭俊
 *Description:TODO
 *@DateTime: 2022/10/19-16:39
 **/

public class UserInformation {
    //用户姓名
    String userName = "彭俊";
    //用户账号
    int account = 20224924;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public String getUserName() {
        return userName;
    }

    public int getAccount() {
        return account;
    }


    //设置初始化欢迎语句
    public String getWelcomeMessage() {
        return "嗨，" + getUserName() + "！\n欢迎您使用储蓄业务系统！\n" + "您的账号为：" + getAccount();
    }

}
