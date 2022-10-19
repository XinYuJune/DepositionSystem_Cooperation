package src.Deposition;

import java.util.Calendar;

/*
 *@Author:222401 彭俊
 *Description: StableDepostion类，继承自Depostion类，增加存款时间和存款利率以及业务信息输出方法
 *@DateTime: 14:34 2022/9/30
 */
public class StableDeposition extends Deposition {
    //存款利率6个档位，使用数组存储
    double[] interestStage = {0.0135, 0.0155, 0.0175, 0.0225, 0.0275, 0.0275};
    //存款时间6个档位，使用数组存储
    int[] interestStageTime = {3, 6, 12, 24, 36, 60};
    //利息变量
    double interest;

    //输入数组下标 返回对应的存款利率
    public double getInterestStage(int stage) {
        return interestStage[stage];
    }

    //每月利率计算，输入金额和存入期限
    public void setInterest(double num, int stage) {
        interest = num * interestStage[stage] / 12;
    }

    //getter方法取出利息
    public double getInterest() {
        return interest;
    }

    //输出定期存入详细信息。
    public void pMessage(int stage) {
        System.out.println("存入成功！当前定期余额为:" + getCurrentBalance() + "(" + interestStageTime[stage] + "个月)" +
                "\n利率为:" + getInterestStage(stage) * 100 + "%" +
                "\n利息为:" + getInterest() + "元/月" +
                "\n本息合计为:" +
                (getCurrentBalance() + getInterest() * interestStageTime[stage]) +
                "元");
        getDeadlineTime(stage);

    }

    //定期存款方法，输入金额和存入时间，自动计算利息及到期时间
    public void setDesProcess(double balance, int stage) {
        setInterest(balance, stage - 1);
        setcurrentBalance(balance);
        pMessage(stage - 1);
    }

    //反馈定期到期时间方法
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
        System.out.printf("到期时间：%d年%02d月%02d日 %02d:%02d:%02d %tA\r\n", year, month, date, hour, minute, second, calendar);
    }
}