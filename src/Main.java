package src;

import java.util.Calendar;
import java.util.Scanner;

/*
 *@Author:222401 彭俊
 *Description:储蓄业务主类
 *@DateTime: 2022/09/29
 **/
public class Main {
    public static void main(String[] args) {

        //初始化Deposition类及其继承类
        Deposition deposition = new Deposition();
        FlexibleDeposition flexibleDeposition = new FlexibleDeposition();
        StableDeposition stableDeposition = new StableDeposition();

        //欢迎语
        System.out.println("欢迎您！" + deposition.getUserName());

        //业务闭环，可供用户多次操作和选择，提供主动结束循环出口
        for (int isEnd = 0; isEnd > -1; isEnd++) {
            System.out.println("请输入数字获取对应业务：\n 1.查询余额\n 2.存定期\n 3.存活期\n 4.退出 ");
            Scanner scanner = new Scanner(System.in);

            //根据输入的数字办理业务
            int inputNum = scanner.nextInt();
            switch (inputNum) {
                //查询余额
                case 1: {
                    //调用flexibleDepostion类和stableDeposition类中的getter方法查询用户相关信息并输出
                    double allNum = flexibleDeposition.getCurrentBalance() + stableDeposition.getCurrentBalance();
                    System.out.println(deposition.getUserName() + "," + deposition.getAccount() + ",您的余额为：\n " +
                            "1.活期：" + flexibleDeposition.getCurrentBalance() + "\n" +
                            " 2.定期：" + stableDeposition.getCurrentBalance() +
                            "\r\n 总余额：" + allNum +
                            "\r\n");
                    break;
                }
                //定期存款存入
                case 2: {

                    //选择存款时间，根据建设银行当前利率设定
                    System.out.println("选择定期存款期限：\n 1.3个月 \n 2.6个月 \n 3.1年 \n 4.2年\n 5.3年\n 6.5年 \n 7.返回上一级");
                    inputNum = scanner.nextInt();
                    System.out.println("输入存款金额：");
                    switch (inputNum) {
                        //建设银行对应6档准备利率
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6: {

                            //判断存款是否大于0、将存入金额、选择的档位、传给类中封装方法sDesProcess处理
                            double isUnderZero=scanner.nextDouble();
                            if (isUnderZero>0){
                                stableDeposition.sDesProcess(isUnderZero, inputNum);
                            }
                            else {System.out.println("输入的存款需大于0元！\r\n");}
                            continue;
                        }
                        default:

                            //选择6档以外的处理方法，反馈错误信息
                            System.out.println("存款期限选择错误！");
                        case 7: {
                            continue;
                        }
                    }
                }
                //活期存款存入
                case 3: {
                    System.out.println("输入存入金额：");
                    //存款不能为零
                    double isUnderZero=scanner.nextDouble();
                    if (isUnderZero>0){
                        //进行存款
                        flexibleDeposition.addBalance(isUnderZero);
                        System.out.println("存入成功！当前活期余额为：" + flexibleDeposition.getCurrentBalance());
                    }else {System.out.println("输入的存款需大于0元！\r\n");}
                    break;

                }
                //退出业务流程
                case 4: {
                    System.out.println("即将退出,感谢您的使用....");
                    isEnd = -2;
                }
            }
        }
    }
}
/*
*@Author:222401 彭俊
*Description: StableDepostion类，继承自Depostion类，增加存款时间和存款利率以及业务信息输出方法
*@DateTime: 14:34 2022/9/30
*/
class StableDeposition extends Deposition {
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
        interest = num * interestStage[stage]/12;
    }
    //getter方法取出利息
    public double getInterest() {
        return interest;
    }
    //输出定期存入详细信息。
    public void pMessage(int stage) {
        System.out.println("存入成功！当前定期余额为:" + getCurrentBalance() +"("+interestStageTime[stage]+"个月)"+
                "\n利率为:" + getInterestStage(stage) * 100 + "%" +
                "\n利息为:" + getInterest() +"元/月"+
                "\n本息合计为:" +
                (getCurrentBalance() + getInterest()*interestStageTime[stage])+
                "元");
        getDeadlineTime(stage);

    }

    //定期存款方法，输入金额和存入时间，自动计算利息及到期时间
    public void sDesProcess(double balance, int stage) {
        setInterest(balance, stage - 1);
            addBalance(balance);
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
/*
*@Author:222401 彭俊
*Description: 继承自Depostion类
*@DateTime: 14:41 2022/9/30
*/
class FlexibleDeposition extends Deposition {
}