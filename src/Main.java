package src;

import java.util.Scanner;

/*
 *@Author:222401 ��
 *Description:����ҵ������
 *@DateTime: 2022/09/29
 **/
public class Main {
    public static void main(String[] args) {

        //��ʼ��Deposition�༰��̳��ࡢScanner��
        Deposition deposition = new Deposition();
        FlexibleDeposition flexibleDeposition = new FlexibleDeposition();
        StableDeposition stableDeposition = new StableDeposition();
        Scanner scanner = new Scanner(System.in);

        //���������ҵ������
        int inputNum;

        //��ʱ��¼��������
        double tempBalance;

        //��ӭ��
        System.out.println(deposition.getWelcomeMessage());

        //ҵ��ջ����ɹ��û���β�����ѡ���ṩ��������ѭ������
        for (int isEnd = 0; isEnd > -1; isEnd++) {
            System.out.println("----�����˵���----\r\n���������ֻ�ȡ��Ӧҵ��\n 1.��ѯ���\n 2.���ҵ��\n 3.ȡ��ҵ��\n 4.�˳�\r\n ------------");
            //������������ְ���ҵ��
            inputNum = scanner.nextInt();
            switch (inputNum) {
                //��ѯ���
                case 1: {
                    //����flexibleDepostion���stableDeposition���е�getter������ѯ�û������Ϣ�����
                    double allNum = flexibleDeposition.getCurrentBalance() + stableDeposition.getCurrentBalance();
                    System.out.println(deposition.getUserName() + "," + deposition.getAccount() + ",�������Ϊ��\n " +
                            "1.���ڣ���" + flexibleDeposition.getCurrentBalance() + "\n" +
                            " 2.���ڣ���" + stableDeposition.getCurrentBalance() +
                            "\r\n ������" + allNum +
                            "\r\n");
                    break;
                }
                //���ҵ��
                case 2: {
                    //ѡ�����ְ�����ڻ��߶���
                    System.out.println("----�����ҵ��----\r\n��ѡ��\n1.�ﶨ�ڴ��\n2.����ڴ��\n----------");
                    inputNum = scanner.nextInt();
                    switch (inputNum) {
                        case 1: {
                            //ѡ����ʱ�䣬���ݽ������е�ǰ�����趨
                            System.out.println("ѡ���ڴ�����ޣ�\n 1.3���� \n 2.6���� \n 3.1�� \n 4.2��\n 5.3��\n 6.5�� \n 7.�������˵�");
                            inputNum = scanner.nextInt();

                            switch (inputNum) {
                                //�������ж�Ӧ6��׼������
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
                                default://ѡ��6������Ĵ�����������������Ϣ
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
                                flexibleDeposition.setCurrentbalance(tempBalance);
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


                //ȡ��ҵ��
                case 3: {
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

