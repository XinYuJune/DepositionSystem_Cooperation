package src.Deposition;

public class Deposition {
    static double currentBalance = 0;
    String userName = "��С�M";
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
            System.out.println("�����������0��");
        }
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    //���ó�ʼ����ӭ���
    public String getWelcomeMessage() {
        return "�ˣ�"+getUserName()+"��\n��ӭ��ʹ�ô���ҵ��ϵͳ��\n"  + "�����˺�Ϊ��" + getAccount();
    }

}