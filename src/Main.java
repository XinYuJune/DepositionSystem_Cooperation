/*
 *@Author:222401 ��
 *Description:����ҵ������
 *@DateTime: 2022/09/29
 **/
package src;

import src.Deposition.Deposition;
import src.Deposition.FlexibleDeposition;
import src.Deposition.StableDeposition;
import src.Deposition.UserInformation;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        //�����ⲿ���ʼ��ҵ���Scanner������
        Deposition deposition = new Deposition();
        FlexibleDeposition flexibleDeposition = new FlexibleDeposition();
        StableDeposition stableDeposition = new StableDeposition();
        UserInformation userInformation = new UserInformation();
        Scanner scanner = new Scanner(System.in);

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
                    "----�����˵���----\n" +
                            "���������ֻ�ȡ��Ӧҵ��\n" +
                            "1.��ѯ���\n" +
                            "2.���ҵ��\n" +
                            "3.ȡ��ҵ��\n" +
                            "4.�û���Ϣ���\n" +
                            "5.�˳�\n" +
                            " ------------");
            //������������ְ���ҵ��
            inputNum = scanner.nextInt();
            switch (inputNum) {
                //��ѯ���
                case 1: {
                    //����flexibleDepostion���stableDeposition���е�getter������ѯ�û������Ϣ�����
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
                            "----�����ҵ��----\r\n" +
                                    "��ѡ��\n" +
                                    "1.�ﶨ�ڴ��\n" +
                                    "2.����ڴ��\n" +
                                    "----------");
                    inputNum = scanner.nextInt();
                    switch (inputNum) {
                        case 1: {
                            //ѡ����ʱ�䣬���ݽ������е�ǰ�����趨
                            System.out.println("ѡ���ڴ�����ޣ�\n " +
                                    "1.3���� \n " +
                                    "2.6���� \n " +
                                    "3.1�� \n " +
                                    "4.2��\n " +
                                    "5.3��\n " +
                                    "6.5�� \n " +
                                    "7.�������˵�");
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
                        case 2: {
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
                            break;
                        }
                        //��ѡ���ȡ����������֣��򷵻ش���
                        default: {
                            System.out.println("ҵ��ѡ�����");
                            break;
                        }
                    }
                }
                break;
                //ȡ��ҵ��
                case 3: {
                    System.out.println("�������Ӧ���ֻ�ȡ��Ӧҵ��:\n" +
                            "1.ȡ����\n" +
                            "2.ȡ����\n" +
                            "3.�������˵�");
                    inputNum=scanner.nextInt();
                    switch(inputNum){
                        //ȡ����
                        case 1:{
                            System.out.println("����ȡ���Ľ�");
                            tempBalance= scanner.nextDouble();

                            //�������Ƿ���ȷ
                            if (tempBalance<0){
                                System.out.println("ȡ��ʧ�ܣ���������Ľ������");
                            }
                            //����Ƿ��㹻
                            else if (flexibleDeposition.getCurrentBalance()==0){
                                System.out.println("ȡ��ʧ�ܣ��˻����㣡");
                            }
                            //�����������������ʧ��
                            else if (tempBalance>flexibleDeposition.getCurrentBalance()){
                                System.out.println("ȡ��ʧ�ܣ�ȡ��������");
                            }
                            else {
                                flexibleDeposition.setcurrentBalance(flexibleDeposition.getCurrentBalance()-tempBalance);
                                System.out.println("ȡ���ɹ���\n����ǰ���õĽ��Ϊ��" +flexibleDeposition.getCurrentBalance());
                            }
                            break;
                        }
                        case 2:{

                        }
                        case 3: {
                            break;
                        }
                        default:{
                            System.out.println("ѡ��ҵ�����");
                        }
                    }
                    break;
                }
                case 4: {
                    System.out.println(
                            "�������ֻ�ȡ��Ӧҵ��:\n" +
                            "1.�޸��û���\n" +
                            "2.�޸�ҵ���˺�\n" +
                            "3.�������˵�\n");
                    inputNum = scanner.nextInt();

                    switch (inputNum) {
                        case 1: {
                            System.out.println("�������µ��û�����");
                            tempString = scanner.nextLine();
                            if (tempString.equals(" ")) {
                                System.out.println("�û�������Ϊ�գ�");
                            } else {
                                userInformation.setUserName(scanner.next());
                            }
                            System.out.println("�޸ĳɹ���\n���û���Ϊ��" + userInformation.getUserName());
                            break;
                        }
                        case 2: {
                            System.out.println("�������µ�ҵ���˺�:");
                            inputNum = scanner.nextInt();
                            if (inputNum >20220000&&inputNum<=20229999) {
                                userInformation.setAccount(scanner.nextInt());
                                System.out.println(" �ɹ���\n���û���Ϊ��" + userInformation.getAccount()+"\n");
                            } else {
                                System.out.println("ҵ���˺Ÿ�ʽ���󣡸�ʽΪ 2022XXXX \n");
                            }
                            break;

                        }
                        default: {
                            System.out.println("�������������������ȷ���֣�");
                        }
                    }
                    break;
                }
                //�˳�ҵ������
                case 5: {
                    System.out.println("�����˳�,��л����ʹ��....");
                    isEnd = -2;
                }
                default:{
                    System.out.println("�������������������ȷ���֣�");
                }
            }
        }
    }
}

