package src.Deposition;

import java.util.Calendar;

/*
 *@Author:222401 ��
 *Description: StableDepostion�࣬�̳���Depostion�࣬���Ӵ��ʱ��ʹ�������Լ�ҵ����Ϣ�������
 *@DateTime: 14:34 2022/9/30
 */
public class StableDeposition extends Deposition {
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
        interest = num * interestStage[stage] / 12;
    }

    //getter����ȡ����Ϣ
    public double getInterest() {
        return interest;
    }

    //������ڴ�����ϸ��Ϣ��
    public void pMessage(int stage) {
        System.out.println("����ɹ�����ǰ�������Ϊ:" + getCurrentBalance() + "(" + interestStageTime[stage] + "����)" +
                "\n����Ϊ:" + getInterestStage(stage) * 100 + "%" +
                "\n��ϢΪ:" + getInterest() + "Ԫ/��" +
                "\n��Ϣ�ϼ�Ϊ:" +
                (getCurrentBalance() + getInterest() * interestStageTime[stage]) +
                "Ԫ");
        getDeadlineTime(stage);

    }

    //���ڴ�����������ʹ���ʱ�䣬�Զ�������Ϣ������ʱ��
    public void setDesProcess(double balance, int stage) {
        setInterest(balance, stage - 1);
        setcurrentBalance(balance);
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