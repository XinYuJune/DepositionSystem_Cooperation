package src.Deposition;

public class Deposition {
    //余额
    double currentBalance = 0;

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
            this.currentBalance += currentBalance;
    }

    public boolean isLegalInputNum(double tempBalance){
        //输入金额是否正确
        if (tempBalance<0){
            System.out.println("取款失败！您的输入的金额有误！");
            return false;
        }
        //余额是否足够
        else if (getCurrentBalance()==0){
            System.out.println("取款失败！账户余额不足！");
            return false;
        }
        //输入金额若大于余额则失败
        else if (tempBalance>getCurrentBalance()){
            System.out.println("取款失败！取出金额超出余额！");
            return false;
        }
        else {
            return true;
        }
    }


}