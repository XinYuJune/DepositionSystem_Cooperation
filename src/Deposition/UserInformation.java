package src.Deposition;/*
 *@Author:222401 ��
 *Description:TODO
 *@DateTime: 2022/10/19-16:39
 **/

public class UserInformation {
    //�û�����
    String userName = "��";
    //�û��˺�
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


    //���ó�ʼ����ӭ���
    public String getWelcomeMessage() {
        return "�ˣ�" + getUserName() + "��\n��ӭ��ʹ�ô���ҵ��ϵͳ��\n" + "�����˺�Ϊ��" + getAccount();
    }

}
