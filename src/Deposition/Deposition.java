package src.Deposition;

public class Deposition {
    //���
    double currentBalance = 0;

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setcurrentBalance(double currentBalance) {
        if (currentBalance > 0) {
            this.currentBalance += currentBalance;
        } else {
            System.out.println("�����������0��");
        }
    }

    public boolean isLegalInputNum(double tempBalance){
        //�������Ƿ���ȷ
        if (tempBalance<0){
            System.out.println("ȡ��ʧ�ܣ���������Ľ������");
            return false;
        }
        //����Ƿ��㹻
        else if (getCurrentBalance()==0){
            System.out.println("ȡ��ʧ�ܣ��˻����㣡");
            return false;
        }
        //�����������������ʧ��
        else if (tempBalance>getCurrentBalance()){
            System.out.println("ȡ��ʧ�ܣ�ȡ��������");
            return false;
        }
        else {
            return true;
        }
    }


}