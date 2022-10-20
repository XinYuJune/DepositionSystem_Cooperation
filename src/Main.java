/*
 *@Author:222401 ��
 *Description:����ҵ������
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

        //�����ⲿ���ʼ��ҵ���Scanner������
        FlexibleDeposition flexibleDeposition = new FlexibleDeposition();
        StableDeposition stableDeposition = new StableDeposition();
        UserInformation userInformation = new UserInformation();
        Scanner scanner = new Scanner(System.in);
        //����ʱ���������е���ʱ���ж�

        Calendar calendar=Calendar.getInstance();
        LocalDate localDate;
        //���������ҵ������
        int inputNum;

        //��ʱ��¼�����
        double tempBalance;

        //��ʱ����������ַ���
        String tempString;


        //ҵ��ջ����ɹ��û���β�����ѡ���ṩ��������ҵ�����
        for (int isEnd = 0; isEnd > -1; isEnd++) {
            //��ӭ��
            System.out.println(userInformation.getWelcomeMessage());
            System.out.println(
                    """
                            ----�����˵���----
                            ���������ֻ�ȡ��Ӧҵ��
                            1.��ѯ���
                            2.���ҵ��
                            3.ȡ��ҵ��
                            4.�û���Ϣ���
                            5.�˳�
                             ------------""");
            //������������ְ���ҵ��
            inputNum = scanner.nextInt();
            switch (inputNum) {
                //��ѯ���
                case 1: {
                    //����flexibleDeposition���stableDeposition���е�getter������ѯ�û������Ϣ�����
                    double allNum = flexibleDeposition.getCurrentBalance() + stableDeposition.getCurrentBalance();
                    System.out.println(userInformation.getUserName() + "," +
                            userInformation.getAccount() + "," +
                            "�������Ϊ��\n" +
                            "1.���ڣ���" + flexibleDeposition.getCurrentBalance() + "\n" +
                            "2.���ڣ���" + stableDeposition.getCurrentBalance() + "\r\n " +
                            "������" + allNum + "\r\n");
                    break;
                }
                //���ҵ��
                case 2: {
                    //ѡ�����ְ�����ڻ��߶���
                    System.out.println(
                            """
                                    ----�����ҵ��----\r
                                    ��ѡ��
                                    1.�ﶨ�ڴ��
                                    2.����ڴ��
                                    ----------""");
                    inputNum = scanner.nextInt();
                    switch (inputNum) {
                        case 1 -> {
                            //ѡ����ʱ�䣬���ݽ������е�ǰ�����趨
                            System.out.println("""
                                    ѡ���ڴ�����ޣ�
                                     1.3����\s
                                     2.6����\s
                                     3.1��\s
                                     4.2��
                                     5.3��
                                     6.5��\s
                                     7.�������˵�""");
                            inputNum = scanner.nextInt();
                            //�������ѡ���ִ�д�����
                            switch (inputNum) {
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6: {
                                    System.out.println("�������");
                                    //�жϴ���Ƿ����0���������ѡ��ĵ�λ���������з�װ����sDesProcess����
                                    tempBalance = scanner.nextDouble();
                                    if (tempBalance > 0) {
                                        stableDeposition.setDesProcess(tempBalance, inputNum);
                                    } else {
                                        System.out.println("����Ĵ�������0Ԫ��\r\n");
                                    }
                                    continue;
                                }
                                //ѡ��6������Ĵ�������Ĭ�Ϸ���������Ϣ
                                default:
                                    System.out.println("�������ѡ�����");
                                case 7: {
                                    continue;
                                }
                            }
                        }
                        case 2 -> {
                            System.out.println("��������");
                            //����Ϊ��
                            tempBalance = scanner.nextDouble();
                            if (tempBalance > 0) {
                                //���д��
                                flexibleDeposition.setcurrentBalance(tempBalance);
                                System.out.println("����ɹ�����ǰ�������Ϊ����" + flexibleDeposition.getCurrentBalance());
                            } else {
                                System.out.println("����Ĵ�������0Ԫ��\r\n");
                            }
                        }

                        //��ѡ���ȡ����������֣��򷵻ش���
                        default -> System.out.println("ҵ��ѡ�����");
                    }
                }
                break;
                //ȡ��ҵ��
                case 3: {
                    System.out.println("""
                            �������Ӧ���ֻ�ȡ��Ӧҵ��:
                            1.ȡ����
                            2.ȡ����
                            3.�������˵�""");
                    inputNum = scanner.nextInt();
                    switch (inputNum) {
                        //ȡ����
                        case 1: {
                            System.out.println("����ȡ���Ľ�");
                            tempBalance = scanner.nextDouble();
                            if (flexibleDeposition.isLegalInputNum(tempBalance)) {
                                flexibleDeposition.setcurrentBalance(flexibleDeposition.getCurrentBalance() - tempBalance);
                                System.out.println("ȡ���ɹ���\n����ǰ���õĽ��Ϊ��" + flexibleDeposition.getCurrentBalance());
                            }
                            break;
                        }
                        case 2: {
                            localDate=LocalDate.of(
                                    calendar.get(Calendar.YEAR),
                                    calendar.get(Calendar.MONTH),
                                    calendar.get(Calendar.DAY_OF_MONTH)
                            );
                            if (stableDeposition.getInputTime().isAfter(localDate)){
                                System.out.println("��δ�����޷�ȡ����");
                            }
                            else {
                                System.out.println("����ȡ�����");
                                tempBalance=scanner.nextDouble();
                                if (stableDeposition.isLegalInputNum(tempBalance)){
                                    stableDeposition.setcurrentBalance(stableDeposition.getCurrentBalance()-tempBalance);
                                    System.out.println("ȡ���ɹ����Ѿ�ȡ��:��"+tempBalance);
                                }

                            }
                        }
                        case 3: {
                            break;
                        }
                        default: {
                            System.out.println("ѡ��ҵ�����");
                        }
                    }
                break;
            }
            case 4: {
                System.out.println(
                        """
                                �������ֻ�ȡ��Ӧҵ��:
                                1.�޸��û���
                                2.�޸�ҵ���˺�
                                3.�������˵�
                                """);
                inputNum = scanner.nextInt();

                switch (inputNum) {
                    case 1 -> {
                        System.out.println("�������µ��û�����");
                        tempString = scanner.nextLine();
                        if (tempString.equals(" ")) {
                            System.out.println("�û�������Ϊ�գ�");
                        } else {
                            userInformation.setUserName(scanner.next());
                        }
                        System.out.println("�޸ĳɹ���\n���û���Ϊ��" + userInformation.getUserName());
                    }
                    case 2 -> {
                        System.out.println("�������µ�ҵ���˺�:");
                        inputNum = scanner.nextInt();
                        if (inputNum > 20220000 && inputNum <= 20229999) {
                            userInformation.setAccount(inputNum);
                            System.out.println(" �ɹ���\n���û���Ϊ��" + userInformation.getAccount() + "\n");
                        } else {
                            System.out.println("ҵ���˺Ÿ�ʽ���󣡸�ʽΪ 2022**** \n");
                        }

                    }
                    default -> System.out.println("�������������������ȷ���֣�");
                }
                break;
            }
            //�˳�ҵ������
            case 5: {
                System.out.println("�����˳�,��л����ʹ��....");
                isEnd = -2;
            }
            default: {
                System.out.println("�������������������ȷ���֣�");
            }
        }
    }
}
}

