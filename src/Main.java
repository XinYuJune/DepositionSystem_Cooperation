package src;

import java.util.Calendar;
import java.util.Scanner;

/*
 *@Author:222401 ��
 *Description:����ҵ������
 *@DateTime: 2022/09/29
 **/
public class Main {
    public static void main(String[] args) {

        //��ʼ��Deposition�༰��̳���
        Deposition deposition = new Deposition();
        FlexibleDeposition flexibleDeposition = new FlexibleDeposition();
        StableDeposition stableDeposition = new StableDeposition();

        //��ӭ��
        System.out.println("��ӭ����" + deposition.getUserName());

        //ҵ��ջ����ɹ��û���β�����ѡ���ṩ��������ѭ������
        for (int isEnd = 0; isEnd > -1; isEnd++) {
            System.out.println("���������ֻ�ȡ��Ӧҵ��\n 1.��ѯ���\n 2.�涨��\n 3.�����\n 4.�˳� ");
            Scanner scanner = new Scanner(System.in);

            //������������ְ���ҵ��
            int inputNum = scanner.nextInt();
            switch (inputNum) {
                //��ѯ���
                case 1: {
                    //����flexibleDepostion���stableDeposition���е�getter������ѯ�û������Ϣ�����
                    double allNum = flexibleDeposition.getCurrentBalance() + stableDeposition.getCurrentBalance();
                    System.out.println(deposition.getUserName() + "," + deposition.getAccount() + ",�������Ϊ��\n " +
                            "1.���ڣ�" + flexibleDeposition.getCurrentBalance() + "\n" +
                            " 2.���ڣ�" + stableDeposition.getCurrentBalance() +
                            "\r\n ����" + allNum +
                            "\r\n");
                    break;
                }
                //���ڴ�����
                case 2: {

                    //ѡ����ʱ�䣬���ݽ������е�ǰ�����趨
                    System.out.println("ѡ���ڴ�����ޣ�\n 1.3���� \n 2.6���� \n 3.1�� \n 4.2��\n 5.3��\n 6.5�� \n 7.������һ��");
                    inputNum = scanner.nextInt();
                    System.out.println("�������");
                    switch (inputNum) {
                        //�������ж�Ӧ6��׼������
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6: {

                            //�жϴ���Ƿ����0���������ѡ��ĵ�λ���������з�װ����sDesProcess����
                            double isUnderZero=scanner.nextDouble();
                            if (isUnderZero>0){
                                stableDeposition.sDesProcess(isUnderZero, inputNum);
                            }
                            else {System.out.println("����Ĵ�������0Ԫ��\r\n");}
                            continue;
                        }
                        default:

                            //ѡ��6������Ĵ�����������������Ϣ
                            System.out.println("�������ѡ�����");
                        case 7: {
                            continue;
                        }
                    }
                }
                //���ڴ�����
                case 3: {
                    System.out.println("��������");
                    //����Ϊ��
                    double isUnderZero=scanner.nextDouble();
                    if (isUnderZero>0){
                        //���д��
                        flexibleDeposition.addBalance(isUnderZero);
                        System.out.println("����ɹ�����ǰ�������Ϊ��" + flexibleDeposition.getCurrentBalance());
                    }else {System.out.println("����Ĵ�������0Ԫ��\r\n");}
                    break;

                }
                //�˳�ҵ������
                case 4: {
                    System.out.println("�����˳�,��л����ʹ��....");
                    isEnd = -2;
                }
            }
        }
    }
}
/*
*@Author:222401 ��
*Description: StableDepostion�࣬�̳���Depostion�࣬���Ӵ��ʱ��ʹ�������Լ�ҵ����Ϣ�������
*@DateTime: 14:34 2022/9/30
*/
class StableDeposition extends Deposition {
    //�������6����λ��ʹ������洢
    double[] interestStage = {0.0135, 0.0155, 0.0175, 0.0225, 0.0275, 0.0275};
    //���ʱ��6����λ��ʹ������洢
    int[] interestStageTime = {3, 6, 12, 24, 36, 60};
    //��Ϣ����
    double interest;
    //���������±� ���ض�Ӧ�Ĵ������
    public double getInterestStage(int stage) {
        return interestStage[stage];
    }
    //ÿ�����ʼ��㣬������ʹ�������
    public void setInterest(double num, int stage) {
        interest = num * interestStage[stage]/12;
    }
    //getter����ȡ����Ϣ
    public double getInterest() {
        return interest;
    }
    //������ڴ�����ϸ��Ϣ��
    public void pMessage(int stage) {
        System.out.println("����ɹ�����ǰ�������Ϊ:" + getCurrentBalance() +"("+interestStageTime[stage]+"����)"+
                "\n����Ϊ:" + getInterestStage(stage) * 100 + "%" +
                "\n��ϢΪ:" + getInterest() +"Ԫ/��"+
                "\n��Ϣ�ϼ�Ϊ:" +
                (getCurrentBalance() + getInterest()*interestStageTime[stage])+
                "Ԫ");
        getDeadlineTime(stage);

    }

    //���ڴ�����������ʹ���ʱ�䣬�Զ�������Ϣ������ʱ��
    public void sDesProcess(double balance, int stage) {
        setInterest(balance, stage - 1);
            addBalance(balance);
            pMessage(stage - 1);
    }

    //�������ڵ���ʱ�䷽��
    public void getDeadlineTime(int stageTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, interestStageTime[stageTime]);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int date = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        int week = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.printf("����ʱ�䣺%d��%02d��%02d�� %02d:%02d:%02d %tA\r\n", year, month, date, hour, minute, second, calendar);
    }
}
/*
*@Author:222401 ��
*Description: �̳���Depostion��
*@DateTime: 14:41 2022/9/30
*/
class FlexibleDeposition extends Deposition {
}