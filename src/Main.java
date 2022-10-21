/*
 *@Author:222401 Jun
 *Description:储蓄业务主类
 *@DateTime: 2022/09/29
 **/
package src;


import src.Deposition.FlexibleDeposition;
import src.Deposition.StableDeposition;
import src.Deposition.UserInformation;

import java.time.LocalDate;

import java.util.Calendar;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        //引入外部类初始化业务和Scanner类输入
        FlexibleDeposition flexibleDeposition = new FlexibleDeposition();
        StableDeposition stableDeposition = new StableDeposition();
        UserInformation userInformation = new UserInformation();
        Scanner scanner = new Scanner(System.in);
        //引入时间相关类进行到期时间判断

        Calendar calendar=Calendar.getInstance();
        LocalDate localDate;
        localDate=LocalDate.of(
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH)+1,
                calendar.get(Calendar.DAY_OF_MONTH)
        );
        //接收输入的业务数字
        int inputNum;

        //临时记录存款金额
        double tempBalance;
        
        //临时接受输入的字符串
        String tempString;


        //业务闭环，可供用户多次操作和选择，提供主动结束业务出口
        for (int isEnd = 0; isEnd > -1; isEnd++) {
            //欢迎语
            System.out.println(userInformation.getWelcomeMessage());
            System.out.println(
                    "----【主菜单】----\n" +
                            "请输入数字获取对应业务：\n" +
                            "1.查询余额\n" +
                            "2.存款业务\n" +
                            "3.取款业务\n" +
                            "4.用户信息变更\n" +
                            "5.退出\n" +
                            " ------------");
            //根据输入的数字办理业务
            inputNum = scanner.nextInt();
            //临时记录输入的定期时间月数
            int inputMonth = 0;
            switch (inputNum) {
                //查询余额
                case 1: {
                    //调用flexibleDeposition类和stableDeposition类中的getter方法查询用户相关信息并输出
                    double allNum = flexibleDeposition.getCurrentBalance() + stableDeposition.getCurrentBalance();
                    System.out.println(userInformation.getUserName() + "," +
                            userInformation.getAccount() + "," +
                            "您的余额为：\n" +
                            "1.活期：￥" + flexibleDeposition.getCurrentBalance() + "\n" +
                            "2.定期：￥" + stableDeposition.getCurrentBalance() + "\r\n " +
                            "总余额：￥" + allNum + "\r\n");
                    break;
                }
                //存款业务
                case 2: {
                    //选择数字办理活期或者定期
                    System.out.println(
                            "----【存款业务】----\r\n" +
                                    "请选择：\n" +
                                    "1.★定期存款\n" +
                                    "2.★活期存款\n" +
                                    "----------");
                    inputNum = scanner.nextInt();
                    switch (inputNum) {
                        case 1: {
                            //选择存款时间，根据建设银行当前利率设定
                            System.out.println("选择定期存款期限：\n " +
                                    "1.3个月 \n " +
                                    "2.6个月 \n " +
                                    "3.1年 \n " +
                                    "4.2年\n " +
                                    "5.3年\n " +
                                    "6.5年 \n " +
                                    "7.返回主菜单");
                            inputNum = scanner.nextInt();
                            //存款期限选择后执行存款操作
                            switch (inputNum) {
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6: {
                                    System.out.println("输入存款金额：");
                                    //判断存款是否大于0、将存入金额、选择的档位、传给类中封装方法sDesProcess处理
                                    tempBalance = scanner.nextDouble();
                                    if (tempBalance > 0) {
                                        stableDeposition.setDesProcess(tempBalance, inputNum);
                                        inputMonth=inputNum;
                                    } else {
                                        System.out.println("输入的存款需大于0元！\r\n");
                                    }
                                    continue;
                                }
                                //选择6档以外的处理方法，默认反馈错误信息
                                default:
                                    System.out.println("存款期限选择错误！");
                                case 7: {
                                    continue;
                                }
                            }
                        }
                        case 2: {
                            System.out.println("输入存入金额：");
                            //存款不能为零
                            tempBalance = scanner.nextDouble();
                            if (tempBalance > 0) {
                                //进行存款
                                flexibleDeposition.setCurrentBalance(tempBalance);
                                System.out.println("存入成功！当前活期余额为：￥" + flexibleDeposition.getCurrentBalance());
                            } else {
                                System.out.println("输入的存款需大于0元！\r\n");
                            }
                            break;
                        }
                        //若选择存取款以外的数字，则返回错误
                        default: {
                            System.out.println("业务选择错误！");
                            break;
                        }
                    }
                }
                break;
                //取款业务
                case 3: {
                    System.out.println("请输入对应数字获取对应业务:\n" +
                            "1.取活期\n" +
                            "2.取定期\n" +
                            "3.返回主菜单");
                    inputNum = scanner.nextInt();
                    switch (inputNum) {
                        //取活期
                        case 1: {
                            System.out.println("输入取出的金额：");
                            tempBalance = scanner.nextDouble();
                            if (flexibleDeposition.isLegalInputNum(tempBalance)) {
                                flexibleDeposition.setCurrentBalance(flexibleDeposition.getCurrentBalance() - tempBalance);
                                System.out.println("取出成功！\n" +
                                        "您当前可用的金额为：" + flexibleDeposition.getCurrentBalance()+"\n" +
                                        "取出时间："+localDate+"\n");
                            }
                            break;
                        }
                        case 2: {

                            if (stableDeposition.getInputTime().isAfter(localDate)){
                                System.out.println("尚未到期无法取出！");
                            }
                            else {
                                System.out.println("输入取出金额");
                                tempBalance=scanner.nextDouble();
                                if (stableDeposition.isLegalInputNum(tempBalance)){
                                    stableDeposition.setCurrentBalance(stableDeposition.getCurrentBalance()-tempBalance);
                                    System.out.println("取出成功！已经取出:￥"+tempBalance+"\n"+
                                            "同时取出所有利息："+stableDeposition.getInterest()*12+"\n" +
                                            "利率为："+(stableDeposition.getInterestStage(inputMonth)*100+"%")+"\n" +
                                            "取出时间："+localDate);

                                }

                            }
                        }
                        case 3: {
                            break;
                        }
                        default: {
                            System.out.println("选择业务错误！");
                        }
                    }
                break;
            }
            case 4: {
                System.out.println(
                        "输入数字获取对应业务:\n" +
                                "1.修改用户名\n" +
                                "2.修改业务账号\n" +
                                "3.返回主菜单\n");
                inputNum = scanner.nextInt();

                switch (inputNum) {
                    case 1: {
                        System.out.println("请输入新的用户名：");
                        tempString = scanner.nextLine();
                        if (tempString.length()>18) {
                            System.out.println("用户名不能超过18位！");
                        } else {
                            userInformation.setUserName(scanner.next());
                        }
                        System.out.println("修改成功！\n新用户名为：" + userInformation.getUserName());
                        break;
                    }
                    case 2: {
                        System.out.println("请输入新的业务账号:");
                        inputNum = scanner.nextInt();
                        if (inputNum > 20220000 && inputNum <= 20229999) {
                            userInformation.setAccount(inputNum);
                            System.out.println(" 成功！\n新业务账号为：" + userInformation.getAccount() + "\n");
                        } else {
                            System.out.println("业务账号格式错误！格式为 2022**** \n");
                        }
                    }
                    case 3:
                        break;
                    default: {
                        System.out.println("数字输入错误！请输入正确数字！");
                    }
                }
                break;
            }
            //退出业务流程
            case 5: {
                System.out.println("即将退出,感谢您的使用....");
                isEnd = -2;
                break;
            }
            default: {
                System.out.println("数字输入错误！请输入正确数字！");
            }
        }
    }
}
}

