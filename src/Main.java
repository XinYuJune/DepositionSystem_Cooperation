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

        //初始化Deposition类及其继承类、Scanner类
        Deposition deposition = new Deposition();
        FlexibleDeposition flexibleDeposition = new FlexibleDeposition();
        StableDeposition stableDeposition = new StableDeposition();
        Scanner scanner = new Scanner(System.in);

        //接收输入的业务数字
        int inputNum;

        //临时记录存款金额变量
        double isUnderZero;

        //欢迎语
        System.out.println(deposition.getWelcomeMessage());

        //业务闭环，可供用户多次操作和选择，提供主动结束循环出口
        for (int isEnd = 0; isEnd > -1; isEnd++) {
            System.out.println("请输入数字获取对应业务：\n 1.查询余额\n 2.存定期\n 3.存活期\n 4.退出 ");
            //根据输入的数字办理业务
            inputNum = scanner.nextInt();
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
                            isUnderZero = scanner.nextDouble();
                            if (isUnderZero > 0) {
                                stableDeposition.setDesProcess(isUnderZero, inputNum);
                            } else {
                                System.out.println("输入的存款需大于0元！\r\n");
                            }
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
                    isUnderZero = scanner.nextDouble();
                    if (isUnderZero > 0) {
                        //进行存款
                        flexibleDeposition.setCurrentbalance(isUnderZero);
                        System.out.println("存入成功！当前活期余额为：" + flexibleDeposition.getCurrentBalance());
                    } else {
                        System.out.println("输入的存款需大于0元！\r\n");
                    }
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

